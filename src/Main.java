import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total number of Monsters: ");
        int noOfMonsters = Integer.parseInt(scanner.nextLine());
        List<Monster> monsterList = new ArrayList<>();
        for (int i = 0; i < noOfMonsters; i++){
            String[] monster = scanner.nextLine().split(" ");
            String colorOfEyes = monster[0];
            String featherColor = monster[1];
            String magicalAbilities = monster[2];
            int monsterSize = Integer.parseInt(monster[3]);
            int monsterStrength = Integer.parseInt(monster[4]);
            int monsterDurability = Integer.parseInt(monster[5]);
            String monsterWeakness = monster[6];
            int aggressionLevel = Integer.parseInt(monster[7]);
            Monster newMonster = new Monster(colorOfEyes, featherColor, magicalAbilities, monsterSize, monsterStrength, monsterDurability, monsterWeakness, aggressionLevel);
            monsterList.add(newMonster);
        }
        Set<Monster> monsterSet = new HashSet<Monster>(monsterList);
        List<Monster> babyMonsterList = new ArrayList<>();
        for (int i = 0; i < monsterList.size()-1; i++) {
            for (int j = i+1; j < monsterList.size(); j++) {
//                Random r = new Random();
//                int low = 0;
//                int high = 2;
//                String colorOfEyes = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).colorOfEyes : monsterList.get(j).colorOfEyes;
//                String featherColor = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).featherColor : monsterList.get(j).featherColor;
//                String magicalAbilities = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).magicalAbilities : monsterList.get(j).magicalAbilities;
//                int monsterSize = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).monsterSize : monsterList.get(j).monsterSize;
//                int monsterStrength = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).monsterStrength : monsterList.get(j).monsterStrength;
//                int monsterDurability = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).monsterDurability : monsterList.get(j).monsterDurability;
//                String monsterWeakness = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).monsterWeakness : monsterList.get(j).monsterWeakness;
//                int aggressionLevel = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).aggressionLevel : monsterList.get(j).aggressionLevel;
//                Monster babyMonster = new Monster(colorOfEyes, featherColor, magicalAbilities, monsterSize, monsterStrength, monsterDurability, monsterWeakness, aggressionLevel);
                Monster babyMonster = monsterList.get(i).createBaby(monsterList.get(j));
                while (monsterSet.contains(babyMonster)){
                    babyMonster = monsterList.get(i).createBaby(monsterList.get(j));
//                    babyMonster.colorOfEyes = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).colorOfEyes : monsterList.get(j).colorOfEyes;
//                    babyMonster.featherColor = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).featherColor : monsterList.get(j).featherColor;
//                    babyMonster.magicalAbilities = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).magicalAbilities : monsterList.get(j).magicalAbilities;
//                    babyMonster.monsterSize = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).monsterSize : monsterList.get(j).monsterSize;
//                    babyMonster.monsterStrength = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).monsterStrength : monsterList.get(j).monsterStrength;
//                    babyMonster.monsterDurability = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).monsterDurability : monsterList.get(j).monsterDurability;
//                    babyMonster.monsterWeakness = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).monsterWeakness : monsterList.get(j).monsterWeakness;
//                    babyMonster.aggressionLevel = (r.nextInt(high-low) + low == 0) ? monsterList.get(i).aggressionLevel : monsterList.get(j).aggressionLevel;
//                    System.out.println("Monster already exists");
                }
                babyMonsterList.add(babyMonster);
            }
        }
        System.out.println(babyMonsterList);
    }
}