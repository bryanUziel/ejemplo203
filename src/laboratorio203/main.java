/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio203;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.BooleanGene;
import org.jgap.impl.DefaultConfiguration;

/**
 *
 * @author bryan
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidConfigurationException {
       Configuration con = new DefaultConfiguration();
       con.setPreservFittestIndividual(true);//elitismo
       con.setPopulationSize(100);//tamanio inicial
       con.setKeepPopulationSizeConstant(true);//tamanio variable
       //Estructura del cromosoma
       Chromosome cromo  = new Chromosome(con,new BooleanGene(con),10);
       //Se establece la estructura para toda la poblacion
       con.setSampleChromosome(cromo);
       //funcion de aptitud
        MaximizarBooleano fitfun = new MaximizarBooleano();
       con.setFitnessFunction(fitfun);
       Genotype genotype = Genotype.randomInitialGenotype(con);
        for (int i = 0; i < 10; i++) {
            genotype.evolve(1);
            //toma la mejor solucion
            IChromosome mejorcito = genotype.getFittestChromosome();
            fitfun.setCromo(mejorcito);
            System.out.println(fitfun);
       }
    }
    
}
