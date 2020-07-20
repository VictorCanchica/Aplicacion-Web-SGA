package sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sga.datos.UsuarioDAO;
import sga.domain.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService {
    
    @Inject
    private UsuarioDAO usuarioDao;

    @Override
    public List<Usuario> listarUsuarios() {
     return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDao.findUsuarioById(usuario);
    }


    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }
    
}
