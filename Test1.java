import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/*
                                                E J E R C I C I O

Durante el ejercicio puede asumir cualquier cosa que no esté explicita en las instrucciones, si lo hace,
debe dejar constancia de ello en la respuesta o pregunta que lo requiera.
A continuación, se presenta una tabla proveniente de una base de datos relacional. También una lista de
cómo se espera visualizar.

Id Nombre idPadre
1 Mascotas 0
2 Gato 1
3 Perro 1
4 Plantas 0
5 Árbol 4
6 Flores 3
7 Micu 2
8 Sasy 2
9 Fido 3
10 Bobby 3
11 Roble 5

Interpretación esperada:
Mascotas
    Gato
        Micu
        Sasy
    Perro
        Fido
        Bobby
Plantas
    Árbol
        Roble
        Flores

TAREAS
1. Agregar un registro nuevo en la tabla.
a. Que pertenezca a la familia de Gato.
b. Que pertenezca a la familia de Fido.
2. Existe un registro que no coincide con la interpretación esperada, indique cual y por qué.

3. En pseudocódigo o en el lenguaje de su preferencia. Proponga una función, de preferencia recursiva,
que permita entregar un listado en consola como se muestra en la Interpretación esperada.
a. Tomar en cuenta que la tabla puede crecer en n cantidad de registros y n cantidad de
niveles anidados.

BONO
4. Si tiene alguna idea en la que se puede trabajar de forma diferente la estructura o lógica de la tabla,
explíquela.

                                       S O L U C I Ó N   E J E R C I C I O:

RESPUESTA 1:

* Se agregó el registro "En la familia de Gato" que pertenece a la familia de "Gato".
* Se agregó el registro "En la familia de Fido" que pertenece a la familia de "Fido".

RESPUESTA 2:

* El dato que no coincide es "Flores" ya que tiene idPadre 3 que pertece a la familia de "Perro".

RESPUESTA 3:

* Se realizoó el siguiente código:

* */





public class Test1 {

    public static List<Data> getDataByIdFather(Integer idPadre, List<Data> data){
        List<Data> dataToFilter = data.stream().filter(val -> val.getIdFather() == idPadre).collect(Collectors.toList());
        return dataToFilter;
    }
    public static String dataToFormat(Data d, Integer subLevel){
        String s = "";
        if(subLevel == 0){
            s += d.getName() + "\n";
        }else if(subLevel > 0){
            String tabs = "";
            for(int i = 0; i < subLevel; i++){
                tabs += "\t";
            }
            s += tabs + d.getName() + "\n";
        }
        return s;
    }

    public static String getInterpretationData(List<Data> data, Integer idFather, Integer subLevel){
        String toReturn = "";
        List<Data> dataToFilter = getDataByIdFather(idFather, data);
        if(dataToFilter.size() == 0) return "";
        for(Data d : dataToFilter){
            toReturn += dataToFormat(d, subLevel);
            subLevel++;
            toReturn += getInterpretationData(data, d.getId(), subLevel);
            subLevel--;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        List<Data> data = new ArrayList<>();
        Data data1 = new Data(1, "Mascotas", 0);
        Data data2 = new Data(2, "Gato", 1);
        Data data3 = new Data(3, "Perro", 1);
        Data data4 = new Data(4, "Plantas", 0);
        Data data5 = new Data(5, "Árbol", 4);
        Data data6 = new Data(6, "Flores", 3);
        Data data7 = new Data(7, "Micu", 2);
        Data data8 = new Data(8, "Sasy", 2);
        Data data9 = new Data(9, "Fido", 3);
        Data data10 = new Data(10, "Bobby", 3);
        Data data11 = new Data(11, "Roble", 5);
        Data data12 = new Data(12, "En la familia de Gato", 2);
        Data data13 = new Data(13, "En la familia de Fido", 9);
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        data.add(data5);
        data.add(data6);
        data.add(data7);
        data.add(data8);
        data.add(data9);
        data.add(data10);
        data.add(data11);
        data.add(data12);
        data.add(data13);



        String s = getInterpretationData(data, 0, 0);


        System.out.println(s);

    }
}
