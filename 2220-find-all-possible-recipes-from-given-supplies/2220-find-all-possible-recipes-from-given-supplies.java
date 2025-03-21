import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int rec = recipes.length;
        List<String> ans = new ArrayList<>();
        Set<String> supply = new HashSet<>(Arrays.asList(supplies));  
        Map<String, List<String>> reci = new HashMap<>();
        for (int i = 0; i < rec; i++) {
            reci.put(recipes[i], ingredients.get(i));
        }

        boolean addedNew;
        do {
            addedNew = false;
            for (String recipe : recipes) {
                if (!ans.contains(recipe) && canBeMade(reci.get(recipe), supply)) {
                    ans.add(recipe);
                    supply.add(recipe); 
                    addedNew = true;
                }
            }
        } while (addedNew);
        return ans;
    }

    private boolean canBeMade(List<String> ingredients, Set<String> supply) {
        for (String ingredient : ingredients) {
            if (!supply.contains(ingredient)) {
                return false;
            }
        }
        return true;
    }
}