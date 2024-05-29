package org.exercice_1.repository;

import org.exercice_1.entity.Comment;
import org.exercice_1.entity.Image;
import org.exercice_1.entity.Product;

import java.util.List;

public class CommentRepository extends BaseRepository<Comment> {

    @Override
    public Comment get(int id) {
        session = factory.openSession();
        Comment comment = session.get(Comment.class, id);
        session.close();
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        session = factory.openSession();
        List<Comment> comments = session.createQuery("from Comment", Comment.class).list();
        session.close();
        return comments;
    }

    public List<Comment> getAllFromProduct(Product product) {
        session = factory.openSession();
        List<Comment> comments = session.createQuery("from Comment p where p.product = :product", Comment.class)
                .setParameter("product", product)
                .getResultList();
        session.close();
        return comments;
    }
}
