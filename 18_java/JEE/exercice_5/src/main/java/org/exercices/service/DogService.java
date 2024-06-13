package org.exercices.service;

import org.exercices.entity.Dog;
import org.exercices.repository.impl.DogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DogService {

    private DogRepository dogRepository;
    private final SessionFactory sessionFactory;
    private Session session;

    public DogService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Dog getDog(int id) {
        session = sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        try {
            return dogRepository.find(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public List<Dog> getAllDogs() {
        session = sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        try {
            return dogRepository.findAll();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return List.of();
        } finally {
            session.close();
        }
    }

    public Dog createDog(Dog dog) {
        return createDog(dog.getName(), dog.getBreed(), dog.getBirthDate().toString());
    }

    public Dog createDog(String name, String breed, String date) {
        session = sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        session.beginTransaction();
        try {
            Dog dog = dogRepository.create(new Dog(name, breed, date));
            session.getTransaction().commit();
            return dog;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public Dog updateDog(Dog dog) {
        return updateDog(dog.getId(), dog.getName(), dog.getBreed(), dog.getBirthDate().toString());
    }

    public Dog updateDog(int id, String newName, String newBreed, String newDate) {
        session = sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        session.beginTransaction();
        try {
            Dog dog = dogRepository.find(id);
            dog.setName(newName);
            dog.setBreed(newBreed);
            dog.setBirthDate(newDate);
            dogRepository.update(dog);
            session.getTransaction().commit();
            return dog;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean deleteDog(int id) {
        session = sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        session.beginTransaction();
        try {
            dogRepository.delete(dogRepository.find(id));
            session.getTransaction().commit();
            return dogRepository.find(id) != null;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

}
