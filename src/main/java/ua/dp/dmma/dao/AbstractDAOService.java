package ua.dp.dmma.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

/**
 * @author Dmytro_Mazan
 */
public class AbstractDAOService<T>
{
    private final Class<T> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDAOService()
    {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    protected T get(Long id)
    {
        return (T) getSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    protected T save(T entity)
    {
        return (T) getSession().save(entity);
    }

    protected void update(T entity)
    {
        getSession().update(entity);
    }

    protected void delete(T entity)
    {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(entityClass);
    }
}
