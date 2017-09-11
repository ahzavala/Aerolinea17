package com.aerolinea.dao;

import com.aerolinea.entidad.Pais;
import com.aerolinea.entidad.Rol;
import com.aerolinea.entidad.Usuario;
import com.aerolinea.util.HibernateUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDaoImpl  implements UsuarioDao{
    
    @Autowired
    @Qualifier("principal")
    private SessionFactory sessionFactory;
    
    @Autowired
    @Qualifier("backup")
    private SessionFactory sessionFactoryBackup;
    
    @Override
    public void guardarUsuario(Usuario u) {
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            s.saveOrUpdate(u);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            System.out.println(e.getMessage());
        }finally{s.close();}
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        List<Usuario> lista;
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("select u from Usuario u join fetch u.pais"
                    + " join fetch u.rol");
            lista=q.list();
            
            s.getTransaction().commit();
            
            return lista;
        } catch (Exception e) {
            return null;
        }finally{s.close();}
        
    }
    public List<Usuario> consultarUsuarios_backup() {
        List<Usuario> lista;
        Session s = sessionFactoryBackup.openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("select u from Usuario u join fetch u.pais"
                    + " join fetch u.rol");
            lista=q.list();
            
            s.getTransaction().commit();
            
            return lista;
        } catch (Exception e) {
            return null;
        }finally{s.close();}
        
    }

    @Override
    public Usuario validarUsuario(Usuario u) {
        Usuario usuario=null;
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            Query q=s.createQuery("select u from Usuario u"
                    + " where idusuario=:usuario and clave=:clave");
            q.setParameter("usuario", u.getIdusuario());
            q.setParameter("clave", sha1(u.getClave()));
            usuario=(Usuario)q.uniqueResult();
            s.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            s.close();
        }
        return usuario;
    }

    @Override
    public List<Rol> getRoles() {
        List<Rol> lista;
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("from Rol");
            lista=q.list();
            s.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            return null;
        }finally{s.close();}
    }

    @Override
    public List<Pais> getPaises() {
        List<Pais> lista;
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            Query q = s.createQuery("from Pais");
            lista=q.list();
            s.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            return null;
        }finally{s.close();}
    }

    @Override
    public Usuario getUsuario(String id) {
        Usuario usuario=null;
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            usuario = (Usuario)s.get(Usuario.class, id);
            s.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            s.close();
        }
        return usuario;
    }

    @Override
    public void EliminarUsuario(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}

