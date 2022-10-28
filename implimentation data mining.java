/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import weka.core.Instance;
//importer les classes requises
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.stemmers.LovinsStemmer;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class implimentation{

    public static void main(String args[]) throws Exception{
    //load dataset
    DataSource source = new DataSource("C:\\Users\\majid bouzar\\Desktop\\spam2.arff");
    Instances dataset = source.getDataSet();
    //définir l'index de classe sur le dernier attribut
    dataset.setClassIndex(dataset.numAttributes()-1);

    //le classificateur de base
    J48 tree = new J48();

    //le filtre
    StringToWordVector filter = new StringToWordVector();
    filter.setInputFormat(dataset);
    filter.setIDFTransform(true);
    filter.setUseStoplist(true);
    LovinsStemmer stemmer = new LovinsStemmer();
    filter.setStemmer(stemmer);
    filter.setLowerCaseTokens(true);

    //Créer lobjet FilteredClassifier
    FilteredClassifier fc = new FilteredClassifier();
    //specifie filtre
    fc.setFilter(filter);
    //specifie base classififcateur
    fc.setClassifier(tree);
    //Construisez le méta-classificateur
    fc.buildClassifier(dataset);

    System.out.println(tree.graph());
    System.out.println(tree);
   }
}