package fcd.constants;

public class FcdConstants {

    public static final String SAVE_CLIENT = "/guardarCliente";
    public static final String UPDATE_CLIENT = "/actualizarCliente";
    public static final String GET_CLIENT = "/consultarCliente/{tipoDocumento}-{numeroDocumento}";
    private static final String VERSION_API = "1.0";
    private static final String CONTEXT_API = "/api/" + VERSION_API;
    public static final String SIGNUP_CONTEXT = CONTEXT_API + "/signUp";


    private FcdConstants() {
    }
}
