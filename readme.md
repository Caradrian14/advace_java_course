#labda expresion

Las expresiones lambda en Java están íntimamente ligadas a las interfaces funcionales. Aquí te explico cómo se relacionan y por qué son tan importantes juntas:

1. Interfaces Funcionales
Una interfaz funcional es una interfaz que contiene un solo método abstracto (aunque puede tener métodos default o static). Ejemplos clásicos:

Runnable (método run())
Comparator<T> (método compare(T o1, T o2))
Consumer<T> (método accept(T t))
Function<T,R> (método apply(T t))

Ejemplo de interfaz funcional personalizada:

`
@FunctionalInterface
interface MiInterfazFuncional {
    void miMetodo(String mensaje);
}
`