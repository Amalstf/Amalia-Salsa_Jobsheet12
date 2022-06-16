/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doublelinkedlists;

/**
 *
 * @author Hp
 */
public class Graph {
    int vertex;
    DoubleLinkedLists list [];
    
    public Graph (int vertex){
        this.vertex = vertex;
        list = new DoubleLinkedLists[vertex];
        for (int i = 0; i < vertex; i ++){
            list [i] = new DoubleLinkedLists();
        }
    }
    public void addEdge (int source, int destination){
        //add edge
        list[source].addFirst(destination);
        
        //add back edge (for undirected)
        list [destination].addFirst(source);
    }
    public void degree(int source) throws Exception{
    
        //degree undirected graph
        System.out.println("degree vertex" + source +" : " +list[source].size());
        
        //degree directed graph 
            //inDegree
        int k, totalIn = 0, totalOut = 0;
        for (int i = 0; i< vertex; i++){
        for (int j = 0; j< list [i].size(); j++){
            if(list [i].get(j)==source)
                ++totalIn;
        }
        //outDegree
        for (k = 0; k < list [source].size(); k++){
            list [source].get (k);
        }
        totalOut = k;
        }
        System.out.println("Indegree dari vertex"+ source + " : " + totalIn);
        System.out.println("Outdegree dari vertex"+ source + " : " + totalOut);
        System.out.println("degree dari vertex"+ source + " : " + (totalIn+totalOut));
    }
    public void removeEdge (int source, int destination) throws Exception{
        for (int i = 0; i < vertex; i++){
            if(i ==destination){
//                list[source].remove(destination);
                  list[source].remove(source);
            }  
        }
    }
    public void removeAllEdges(){
            for (int i = 0; i < vertex; i++){
            list[i].clear();
        }
            System.out.println("Graph Berhasil Dikosongkan");
        }
    public void printGraph() throws Exception{
        String Kota = " ";
        for (int i = 0; i <vertex; i++){
            if(list[i].size()>0){
                if (i == 0 ){
                    Kota = "Malang";
                }else if (i == 1){
                    Kota = "Surabaya";
                }else if (i == 2){
                    Kota = "Gresik";
                }else if (i == 3){
                    Kota = "Pandaan";
                }else if (i == 4){
                    Kota = "Bandung";
                }else{
                    Kota = "Jakarta";
                }
                System.out.print(" Vertex " + Kota + " terhubung dengan ");
                for(int j = 0; j < list[i].size(); j++){
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println("");
            }
        }
        System.out.println(" ");
    }
        public boolean graphType(int source, int destination){
        list[source].addFirst(destination);
        return true;
    }
}
