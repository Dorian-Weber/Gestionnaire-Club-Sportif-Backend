package com.mns.cda.filsrouge.dao;

import com.mns.cda.filsrouge.dto.FriendDTO;
import com.mns.cda.filsrouge.model.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelationDAO extends JpaRepository<Relation, Relation.Key> {

    //récupère la liste des amis et fait le tri en fonction de demandeur ou demandé.
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

    // Retrouve une relation entre deux utilisateurs en fonction de demandeur ou demander.
    @Query("""
    SELECT r FROM Relation r
    WHERE (r.key.firstUserId = :id1 AND r.key.secondUserId = :id2)
       OR (r.key.firstUserId = :id2 AND r.key.secondUserId = :id1)
""")
    Optional<Relation> findRelationBetween(int id1, int id2);


    // Fait la liste des relations qui sont en attente de réponse par l'utilisateur.
    @Query("""
SELECT new com.mns.cda.filsrouge.dto.FriendDTO(
    r.firstUser.idAppUser,
    r.firstUser.appUserPseudo,
    r.firstUser.appUserFirstName,
    r.firstUser.appUserName
)
FROM Relation r
WHERE r.secondUser.idAppUser = :idUser
  AND r.relationStatus = 'PENDING'
""")
    List<FriendDTO> findPendingReceived(@Param("idUser") int idUser);

    //Fait la liste des relations que l'utilisateur à demander et qui sont en attente.
    @Query("""
SELECT new com.mns.cda.filsrouge.dto.FriendDTO(
    r.secondUser.idAppUser,
    r.secondUser.appUserPseudo,
    r.secondUser.appUserFirstName,
    r.secondUser.appUserName
)
FROM Relation r
WHERE r.firstUser.idAppUser = :idUser
  AND r.relationStatus = 'PENDING'
""")
    List<FriendDTO> findPendingSent(int idUser);

}

