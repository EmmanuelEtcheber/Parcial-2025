import com.enums.EFaccion;
import com.interfaces.IAtacar;
import com.model.Agil;
import com.model.GestorCuarentena;
import com.model.Humano;
import com.model.Infectado;

void main() {
    GestorCuarentena gestor = new GestorCuarentena();
    boolean seguir = true;
    do {
        switch (mostrarMenu()){
            case 1: // AGREGAR HUMANO
                Humano humano = crearHumano();
                gestor.agregar(humano);
                break;
            case 2: // AGREGAR INFECTADO
                Infectado infectado = crearInfectado();
                gestor.agregar(infectado);
                break;
            case 3: // BUSCAR PARTICIPANTE
                IAtacar buscado = gestor.buscarParticipante(menuBuscar());
                if(buscado != null){
                    IO.println("--- Participante encontrado ---");
                    IO.println(buscado.toString());
                } else {
                   IO.println("No existe participante con el id ingresado.");
                }
                break;
            case 4: // ELIMINAR PARTICIPANTE
                if(gestor.eliminar(menuBuscar())) {
                    IO.println("El participante fue eliminado.");
                } else {
                    IO.println("Ocurrio un error y no se pudo eliminar el participante.");
                }
                break;
            case 5: // LISTAR
                IO.println(gestor.toString());
                break;
            case 6: // MODIFICAR CANTIDAD DE INFECTADOS
                if(gestor.modificarCantInfectados(menuBuscar(), ingresarCantInfectados())){
                    IO.println("Se modifico la cantidad de infectados.");
                }else{
                    IO.println("Ocurrio un error y no se pudo modificar la cantidad de infectados del participante.");
                }
                break;
            case 7: // CONTAR HUMANOS POR TIPO
                EFaccion faccion = getFaccion();
                IO.println("Participantes de " + faccion + ":" + gestor.contarPorTipo(faccion));
                break;
            case 8:
                seguir = false;
                break;
            default:
                IO.println("\nOpcion incorrecta. Intente nuevamente...");
        }
    }while(seguir);
}

private Integer ingresarCantInfectados() {
    Scanner scanner = new Scanner(System.in);
    IO.print("Ingrese nueva cantidad de infectados: ");
    return scanner.nextInt();
}

private UUID menuBuscar() {
    Scanner scanner = new Scanner(System.in);
    IO.println("Ingrese id para buscar participante: ");
    String id = scanner.nextLine();
    return UUID.fromString(id);
}

private Infectado crearInfectado() {
    Scanner scanner = new Scanner(System.in);
    Infectado infectado = new Infectado();
    IO.print("Ingrese nombre: ");
    infectado.setNombre(scanner.nextLine());
    IO.print("Ingrese origen: ");
    infectado.setOrigen(scanner.nextLine());
    IO.print("Ingrese la cantidad de humanos que infecto: ");
    infectado.setCantInfectados(scanner.nextInt());

    return infectado;
}

private EFaccion getFaccion() {
    switch (menuFaccion()) {
        case 1:
            return EFaccion.MILITAR;
        case 2:
            return EFaccion.COMUNA4;
        case 3:
            return EFaccion.LUCIERNAGA;
        default:
            return null;
    }
}

private Integer menuFaccion(){
    Scanner scanner = new Scanner(System.in);
    IO.println("1 - " + EFaccion.MILITAR);
    IO.println("2 - " + EFaccion.COMUNA4);
    IO.println("3 - " + EFaccion.LUCIERNAGA);
    IO.print("Ingrese faccion (1 - 2 - 3): ");
    return scanner.nextInt();
}

private Humano crearHumano() {
    Scanner scanner = new Scanner(System.in);
    Humano humano = new Humano();
    IO.print("Ingrse nombre: ");
    humano.setNombre(scanner.nextLine());
    IO.print("Ingrese edad: ");
    humano.setEdad(scanner.nextInt());
    humano.setFaccion(getFaccion());

    return humano;
}

private int mostrarMenu() {
    IO.println("--- BIENVENIDO ---");
    IO.println("1. Agregar humano.");
    IO.println("2. Agregar infectado.");
    IO.println("3. Buscar participante.");
    IO.println("4. Eliminar participante.");
    IO.println("5. Listar participantes.");
    IO.println("6. Modificar cantidad de infectados.");
    IO.println("7. Contar humanos por tipo.");
    IO.println("8. Salir.");
    IO.print("\nIngrese una opcion:");
    return Integer.parseInt(IO.readln());
}