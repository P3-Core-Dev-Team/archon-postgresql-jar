package com.p3solutions.archon_mongodb_persistence.user.mapper;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.p3solutions.archon_mongodb_persistence.user.entity.UserModel;
import com.p3solutions.archon_mongodb_persistence.user.repository.UserRepository;
import com.p3solutions.archon_mongodb_persistence.utill.MapperUtils;
import com.p3solutions.common_beans_dto.users.abstract_repository.UserAbstractRepository;
import com.p3solutions.common_beans_dto.users.mapper_beans.UserModelMapperBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service("UserAbstractRepository")
public class UserMapperImpl implements UserAbstractRepository {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MapperUtils mapperUtils;
    @Autowired
    Gson gson;
    @Override
    public Optional<UserModelMapperBean> findById(final String id) {
        Optional<UserModel> userModelOptional = userRepository.findById(id);
        Optional<UserModelMapperBean> userModerResponseDto = Optional.empty();
        if (userModelOptional.isPresent()) {
            userModerResponseDto = Optional.of(gson.fromJson(userModelOptional.get().getUserData(), UserModelMapperBean.class));
        }
        return userModerResponseDto;
    }

    @Override
    public List<UserModelMapperBean> findAll() {
        List<UserModelMapperBean> userModelMapperBeanList=new ArrayList<>();
        Iterable<UserModel> userModelIterable=userRepository.findAll();
        Iterator<UserModel> iterator = userModelIterable.iterator();
        while (iterator.hasNext()) {
            userModelMapperBeanList.add(gson.fromJson(iterator.next().getUserData(), UserModelMapperBean.class));
        }
        return userModelMapperBeanList;
    }

    @Override
    public UserModelMapperBean save(UserModelMapperBean inviteUserResponseDTO) {
        UserModel userModel = mapperUtils.map(inviteUserResponseDTO, UserModel.class);
        UserModel userModelSaved = userRepository.save(userModel);
        return mapperUtils.map(userModelSaved, UserModelMapperBean.class);
    }

    @Override
    public List<UserModelMapperBean> findAccountLockedUser() {
        return null;
    }

    @Override
    public List<UserModelMapperBean> getUserDetails(Integer page, String emailAddress) throws Exception {
        return null;
    }

    @Override
    public Long findCountOfRecords(Integer offset, Boolean accessRevoked, Boolean accountLocked, String search, Integer limit, String sort) throws Exception {
        return null;
    }

    @Override
    public List<UserModelMapperBean> findUsersBySort(Integer offset, Boolean accessRevoked, Boolean accountLocked, String search, Integer limit, String sort) throws Exception {
        return null;
    }

    @Override
    public Optional<UserModelMapperBean> findByIdIgnoreCase(String userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserModelMapperBean> findByIdAndType(String id, String type) {
        return Optional.empty();
    }

    /*@Override
    public List<UserModelMapperBean> findAccountLockedUser() {
        Query query = new Query();
        query.addCriteria(Criteria.where("accountLocked").is(true));
        List<UserModel> userDetails = mongoOperations.find(query, UserModel.class);
        List<UserModelMapperBean> responseList = new ArrayList<UserModelMapperBean>();
        if (userDetails != null && !userDetails.isEmpty()) {
            mapperUtils.map(userDetails, UserModelResponseDTO.class);
        }

        return responseList;
    }*/

    /*@Override
    public List<UserModelMapperBean> getUserDetails(Integer page, String emailAddress) throws Exception {
        Query query = new Query();
        Integer lastPage = 0;

        if (page == null) {
            lastPage = 1 + 49;
            page = 1;
        } else {
            lastPage = page * 50;
        }
        if (page == 1) {
            query.skip(0);
        } else {
            query.skip(50 * (page - 1));
        }

        if (!StringUtils.isEmpty(emailAddress)) {
            query.addCriteria(Criteria.where("emailAddress").regex(emailAddress, "i"));
        }
        query.skip(page > 0 ? (page - 1) : 0);
        query.limit(lastPage);
        List<UserModel> userModel = mongoOperations.find(query, UserModel.class);
        return mapperUtils.map(userModel, UserModelMapperBean.class);
    }

    @Override
    public Long findCountOfRecords(Integer offset, Boolean accessRevoked, Boolean accountLocked, String search,
                                   Integer limit, String sort) throws Exception {
        Criteria c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null;
        Query query = null;
        if (!org.apache.commons.lang3.StringUtils.isBlank(search)) {
            c1 = Criteria.where("emailAddress").regex(search, "i");
            c2 = Criteria.where("firstName").regex(search, "i");
            c3 = Criteria.where("lastName").regex(search, "i");
            c4 = Criteria.where("_id").regex(search, "i");
        }
        c5 = Criteria.where("accessRevoked").is(accessRevoked);
        c6 = Criteria.where("accountLocked").is(accountLocked);
        c7 = Criteria.where("_id").is("superadmin");
        c8 = Criteria.where("isSoftDeleted").is(true);
        if (!org.apache.commons.lang3.StringUtils.isBlank(search)) {
            query = new Query(new Criteria().orOperator(c1, c2, c3, c4).andOperator(c5, c6).norOperator(c7, c8));
        } else {
            query = new Query(new Criteria().andOperator(c5, c6).norOperator(c7, c8));
        }
        if (sort.startsWith("-")) {
            sort = sort.substring(1);
        } else {
            sort = sort.substring(1);
            //  query.with(new Sort(Direction.ASC, sort));
        }
        query.collation(Collation.of("en"));

        Long totalCount = mongoOperations.count(query, UserModel.class);

        return totalCount;
    }

    @Override
    public List<UserModelMapperBean> findUsersBySort(Integer offset, Boolean accessRevoked, Boolean accountLocked,
                                                     String search, Integer limit, String sort) throws Exception {
        Criteria c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null;
        Query query = null;
        if (!org.apache.commons.lang3.StringUtils.isBlank(search)) {
            c1 = Criteria.where("emailAddress").regex(search, "i");
            c2 = Criteria.where("firstName").regex(search, "i");
            c3 = Criteria.where("lastName").regex(search, "i");
            c4 = Criteria.where("_id").regex(search, "i");

        }
        c5 = Criteria.where("accessRevoked").is(accessRevoked);
        c6 = Criteria.where("accountLocked").is(accountLocked);
        c7 = Criteria.where("_id").is("superadmin");
        c8 = Criteria.where("isSoftDeleted").is(true);
        if (!org.apache.commons.lang3.StringUtils.isBlank(search)) {
            query = new Query(new Criteria().orOperator(c1, c2, c3, c4).andOperator(c5, c6).norOperator(c7, c8));
        } else {
            query = new Query(new Criteria().andOperator(c5, c6).norOperator(c7, c8));
        }
        if (sort.startsWith("-")) {
            sort = sort.substring(1);
            Pageable pageable = PageRequest.of(offset, limit, Sort.by(sort).descending());
            query.with(pageable);
        } else {
            sort = sort.substring(1);
            Pageable pageable = PageRequest.of(offset, limit, Sort.by(sort).ascending());
            query.with(pageable);
        }
        query.collation(Collation.of("en"));

//        if (offset == 1) {
//            query.skip(0);
//        } else {
//            query.skip(limit * (offset - 1));
//        }
//        query.limit(limit);

        List<UserModel> modelList = mongoOperations.find(query, UserModel.class);


        return mapperUtils.map(modelList, UserModelMapperBean.class);

    }

    @Override
    public Optional<UserModelMapperBean> findByIdIgnoreCase(String userId) {
        Criteria c1 = Criteria.where("_id").regex("^" + userId + "$", "i");
        Query query = new Query();
        query.addCriteria(c1);
        List<UserModel> userModel = mongoOperations.find(query, UserModel.class);
        Optional<UserModelMapperBean> dtoOptional = Optional.empty();
        if (!userModel.isEmpty()) {
            dtoOptional = Optional.of(mapperUtils.map(userModel.get(0), UserModelMapperBean.class));
        }
        return dtoOptional;
    }

    @Override
    public Optional<UserModelMapperBean> findByIdAndType(String id, String type) {
        Criteria c1 = Criteria.where("_id").is(id).and("type").is(type);
        Query query = new Query();
        query.addCriteria(c1);
        List<UserModel> userModel = mongoOperations.find(query, UserModel.class);
        if (!userModel.isEmpty()) {
            return Optional.of(mapperUtils.map(userModel.get(0), UserModelMapperBean.class));
        }
        return Optional.empty();
    }*/

}
