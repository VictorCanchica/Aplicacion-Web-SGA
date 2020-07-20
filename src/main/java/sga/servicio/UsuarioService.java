package sga.servicio;

import java.util.List;
import javax.ejb.Local;
import sga.domain.Usuario;

@Local
public interface UsuarioService {
    public List <Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
    public void editarUsuario(Usuario usuario);
    
}
