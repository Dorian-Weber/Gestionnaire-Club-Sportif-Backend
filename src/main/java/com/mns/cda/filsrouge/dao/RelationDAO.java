package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.model.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationDAO extends JpaRepository<Relation, Relation.Key> {

    @Query("""
    SELECT new com.mns.cda.filsrouge.dto.FriendDTO(
        CASE
            WHEN r.firstUser.idAppUser = :idUser THEN r.secondUser.idAppUser
            ELSE r.firstUser.idAppUser
        END,
        CASE
            WHEN r.firstUser.idAppUser = :idUser THEN r.secondUser.appUserPseudo
            ELSE r.firstUser.appUserPseudo
        END,
        CASE
            WHEN r.firstUser.idAppUser = :idUser THEN r.secondUser.appUserFirstName
            ELSE r.firstUser.appUserFirstName
        END,
        CASE
            WHEN r.firstUser.idAppUser = :idUser THEN r.secondUser.appUserName
            ELSE r.firstUser.appUserName
        END
    )
    FROM Relation r
    WHERE (r.firstUser.idAppUser = :idUser OR r.secondUser.idAppUser = :idUser)
      AND r.relationStatus = 'ACCEPTED'
""")
    List<FriendDTO> findListFriendsByIdUser(@Param("idUser") int idUser);
}
