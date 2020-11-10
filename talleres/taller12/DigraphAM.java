import java.util.ArrayList;
public class DigraphAM extends Graph
{
    //Grafo con matriz
    int[][] mat;
    public DigraphAM(int size){
        super(size);
        mat = new int[size][size];
        
        for(int i=1; i<size; i++){
            mat[i][0] = i;
            mat[0][i] = i;
        }
    }
    
     public void addArc(int source, int destination, int weight){
      mat[source][destination] = weight;
   }
    
    
    public int getWeight(int source, int destination){
       return mat[source][destination];
    }

     public ArrayList<Integer> getSuccessors(int vertex)
   {
       ArrayList<Integer> np= new ArrayList<>();
     for(int i=1; i<size; i++){
        if(mat[vertex][i]!=0){
         np.add(mat[0][i]);
        }
      }
     return np;   
   }
   
   public boolean getRouteDFS(int source, int destination){
        if (mat[source][destination] != 0) return true;
        for(int i=1; i<size; i++){
            if (mat[source][i] != 0) return getRouteDFS(i, destination);
        }
        return false;
   }

   public boolean getRouteBFS(int source, int destination){
        // if (mat[source][destination] != 0) return true;
        for(int i=1; i<size; i++){
            if (mat[source][i] != 0){
                for (int j = 1; j<size; j++){
                    if (mat[i][j] != 0 && j == destination) return true;
                }
                return getRouteBFS(i, destination);
            }
        }

        return false;
   }
   public static void main(String[] args) {
        DigraphAM dg = new DigraphAM(5);
        dg.addArc(1, 3, 1);
        dg.addArc(1, 4, 1);
        dg.addArc(3, 4, 1);
        dg.addArc(4, 2, 1);
        System.out.println(dg.getRouteBFS(1, 2));
        DigraphAM dg2 = new DigraphAM(5);
        dg2.addArc(1, 3, 1);
        dg2.addArc(2, 3, 1);
        dg2.addArc(3, 4, 1);
        dg2.addArc(4, 2, 1);
        System.out.println(dg.getRouteDFS(1, 2));
   }
}