import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
import java.lang.Math;

public class Main{
    public LinkedList<Bee> bees;
    public float midLat, midLon, midAlt;
    public ArrayList<Float> minimums;

    public Main() throws IOException{
        this.bees = new LinkedList<Bee>();
        this.minimums = new ArrayList<Float>();
        readFile("bees.txt");
    }
    public void generateTree(LinkedList<Bee> bees, ArrayList<Float> startingPoints, float midLat, float midLon, float midAlt){
        ArrayList<LinkedList<Bee>> tree = new ArrayList(8);
        for(int i = 0; i < 8; i++){
            tree.add(new LinkedList<Bee>());
        }
        for (int i = 0; i < bees.size(); i++){
            Bee beeF = bees.poll();
            tree.get(hashAlg(beeF, startingPoints, midLat, midLon, midAlt)).addFirst(beeF);
        }
        if (!diagonal(startingPoints, midLat, midLon, midAlt)){
            for (int i = 0; i < 8; i++){
                if (tree.get(i).size() > 0){
                    switch (i){
                        case 0:
                            generateTree(bees, startingPoints, midLat/2, midLon/2, midAlt/2);
                            break;
                        case 1:
                            startingPoints.set(2, startingPoints.get(2) + midAlt);
                            generateTree(bees, startingPoints, midLat/2, midLon/2, midAlt/2);
                            break;
                        case 2:
                            startingPoints.set(1, startingPoints.get(1) + midLon);
                            generateTree(bees, startingPoints, midLat/2, midLon/2, midAlt/2);
                            break;
                        case 3:
                            startingPoints.set(2, startingPoints.get(2) + midAlt);
                            startingPoints.set(1, startingPoints.get(1) + midLon);
                            generateTree(bees, startingPoints, midLat/2, midLon/2, midAlt/2);
                            break;
                        case 4:
                            startingPoints.set(0, startingPoints.get(0) + midLat);
                            generateTree(bees, startingPoints, midLat/2, midLon/2, midAlt/2);
                            break;
                        case 5:
                            startingPoints.set(0, startingPoints.get(0) + midLat);
                            startingPoints.set(2, startingPoints.get(2) + midAlt);
                            generateTree(bees, startingPoints, midLat/2, midLon/2, midAlt/2);
                            break;
                        case 6:
                            startingPoints.set(0, startingPoints.get(0) + midLat);
                            startingPoints.set(1, startingPoints.get(1) + midLon);
                            generateTree(bees, startingPoints, midLat/2, midLon/2, midAlt/2);
                            break;
                        default:
                            startingPoints.set(0, startingPoints.get(0) + midLat);
                            startingPoints.set(1, startingPoints.get(1) + midLon);
                            startingPoints.set(2, startingPoints.get(2) + midAlt);
                            generateTree(bees, startingPoints, midLat/2, midLon/2, midAlt/2);
                            break;
                    }
                }
            }
        }else {
            for (int i = 0; i < 8; i++){
                if (tree.get(i).size() > 0){
                    printBees(tree.get(i), startingPoints, midLat, midLon, midAlt);
                }
            }
        }
    }
    public void readFile (String file) throws IOException{
        ArrayList<Float> lat = new ArrayList<Float>();
        ArrayList<Float> lon = new ArrayList<Float>();
        ArrayList<Float> alt = new ArrayList<Float>();
        try (BufferedReader reader = new BufferedReader( new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                String [] mins = line.split(",");  
                lat.add(Float.parseFloat(mins[0]));
                lon.add(Float.parseFloat(mins[1]));
                alt.add(Float.parseFloat(mins[2]));
                Bee bee = new Bee(Float.parseFloat(mins[0]), Float.parseFloat(mins[1]), Float.parseFloat(mins[2]));
                this.bees.addFirst(bee);
            } 
        } catch (IOException e){
            e.printStackTrace();
        }
        this.minimums.add((float)Collections.min(lat));
        this.minimums.add((float)Collections.min(lon));
        this.minimums.add((float)Collections.min(alt));
        float mlat = (minimums.get(0) + (float)Collections.max(lat)) / 2;
        float mlon = (minimums.get(1) + (float)Collections.max(lon)) / 2;
        float malt = (minimums.get(2) + (float)Collections.max(alt)) / 2;
        this.midLat = mlat - this.minimums.get(0);
        this.midLon = mlon - this.minimums.get(1);
        this.midAlt = malt - this.minimums.get(2);
    }    
    public boolean diagonal(ArrayList<Float> startingPoints, float midLat, float midLon, float midAlt){
        if (Math.sqrt(Math.pow(midLat * 111700, 2) + Math.pow(midLon * 111700, 2) + Math.pow(midAlt, 2)) < 100) return true;
        return false;
    }
    public int hashAlg(Bee bee, ArrayList<Float> startingPoints, float midLat, float midLon, float midAlt){
        if (bee.x <= startingPoints.get(0) + midLat){
            if (bee.y <= startingPoints.get(1) + midLon){
                if (bee.z <= startingPoints.get(2) + midAlt) {
                    return 0;
                }
                return 1;
            }else {
                if (bee.z <= startingPoints.get(2) + midAlt){
                    return 2;
                }
                return 3;
            }
        }else {
            if (bee.y <= startingPoints.get(1) + midLon){
                if (bee.z <= startingPoints.get(2) + midAlt){
                    return 4;
                }
                return 5;
            }else {
                if (bee.z <= startingPoints.get(2) + midAlt){
                    return 6;
                }
                return 7;
            }
        }
    }
    public void printBees(LinkedList<Bee> bees, ArrayList<Float> startingPoints, float midLat, float midLon, float midAlt) {
        for (Bee bee:bees) {
            System.out.println( bee.x + ", " + bee.y + ", " + bee.z + " " + Math.sqrt(Math.pow(midLat * 111700, 2) + Math.pow(midLon * 111700, 2) + Math.pow(midAlt, 2)) + " meters");
        }
    }

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        main.generateTree(main.bees, main.minimums, main.midLat, main.midLon, main.midAlt);
    }
}