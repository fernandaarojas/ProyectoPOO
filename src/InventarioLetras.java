public class InventarioLetras {

    private int[] letras;
    private int total;
    private int distintas;

    // Constructor
    public InventarioLetras(String texto) {

        letras = new int[26];
        total = 0;
        distintas = 0;

        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {

            char caracter = texto.charAt(i);

            if (caracter >= 'a' && caracter <= 'z') {

                int posicion = caracter - 'a';

                if (letras[posicion] == 0) {

                    distintas++;
                }

                letras[posicion]++;
                total++;
            }
        }
    }

    // Encriptar letra
    public char encriptarCesar(char letra) {

        letra = Character.toLowerCase(letra);

        if (letra < 'a' || letra > 'z') {

            return letra;
        }

        int nuevaPosicion = ((letra - 'a') + 3) % 26;

        return (char)(nuevaPosicion + 'a');
    }

    // Desencriptar letra
    public char desencriptarCesar(char letra) {

        letra = Character.toLowerCase(letra);

        if (letra < 'a' || letra > 'z') {

            return letra;
        }

        int nuevaPosicion = ((letra - 'a') - 3 + 26) % 26;

        return (char)(nuevaPosicion + 'a');
    }

    // Encriptar palabra
    public String encriptarPalabra(String palabra, int desplazamiento) {

        String resultado = "";

        for (int i = 0; i < palabra.length(); i++) {

            resultado += encriptarCesar(palabra.charAt(i));
        }

        return resultado;
    }

    // Desencriptar palabra
    public String desencriptarPalabra(String palabra, int desplazamiento) {

        String resultado = "";

        for (int i = 0; i < palabra.length(); i++) {

            resultado += desencriptarCesar(palabra.charAt(i));
        }

        return resultado;
    }

    // Obtener cantidad de letra
    public int get(char letra) {

        letra = Character.toLowerCase(letra);

        if (letra < 'a' || letra > 'z') {

            throw new IllegalArgumentException("Letra inválida");
        }

        return letras[letra - 'a'];
    }

    // Modificar cantidad
    public void set(char letra, int valor) {

        letra = Character.toLowerCase(letra);

        if (letra < 'a' || letra > 'z' || valor < 0) {

            throw new IllegalArgumentException("Datos incorrectos");
        }

        int posicion = letra - 'a';

        total -= letras[posicion];

        if (letras[posicion] == 0 && valor > 0) {

            distintas++;
        }

        if (letras[posicion] > 0 && valor == 0) {

            distintas--;
        }

        letras[posicion] = valor;

        total += valor;
    }

    // Cantidad total de letras
    public int size() {

        return total;
    }

    // Verificar si está vacío
    public boolean isEmpty() {

        return distintas == 0;
    }