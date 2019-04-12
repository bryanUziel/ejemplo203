/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio203;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;
import org.jgap.impl.BooleanGene;

/**
 *
 * @author bryan
 */
public class MaximizarBooleano extends FitnessFunction{
    private IChromosome cromo;
    
    private int  bin2intString(String cad){
        return Integer.parseInt(cad,2);
    }
    
    private String asString(IChromosome i){
        Gene[] genes = i.getGenes();//obtener todos los genes como arreglo
        String cad = "";
        for(int j = 0;j < genes.length;j++){//convierte a cadena
            BooleanGene gen = (BooleanGene)genes[genes.length-1-j];//de ceros y unos
            if(gen.booleanValue()){//el arreglo de genes
                cad +="1";
            }else{
                cad +="0";
            }   
        }
        return cad;
    }
    public String swap(String cad){
        int cont = 0;
        char caracter = cad.charAt(0);
        for (int i = 1; i < 10; i++) {
            if(caracter != cad.charAt(i)){
                cont++;
            }
        }
        cad = Integer.toString(cont);
        return cad;
    }
    
    @Override
    protected double evaluate(IChromosome i) {
        return bin2intString(asString(i));
    }

    @Override
    public String toString() {
        return asString(cromo) + "= "+ bin2intString(asString(cromo)) + "\tswap: " + swap(asString(cromo));
    }

    public IChromosome getCromo() {
        return cromo;
    }

    public void setCromo(IChromosome cromo) {
        this.cromo = cromo;
    }
    
}
