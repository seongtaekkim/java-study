package createobject;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static createobject.NyPizza.Size.SMALL;
import static createobject.Pizza.Topping.*;

public class Item02 {

    public static void main(String[] args) {

        NutritionFacts3 cocaCola = new NutritionFacts3.Builder(240,8)
                .calories(100).sodium(30).carbohydrate(5).build();



        NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();
    }
}

class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int cabohydrate;

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize,servings,0);
    }
    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings,calories,0);
    }
    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories,fat, 0);
    }
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0)
    }
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int cabohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.cabohydrate = cabohydrate;
    }
}

class NutritionFacts2 {
    private int servingSize=-1;
    private  int servings=-1;
    private  int calories=0;
    private  int fat=0;
    private  int sodium=0;
    private  int cabohydrate=0;

    public NutritionFacts2() {}
    public void setServingSize(int val) { servingSize = val;}
    public void setServings(int val) {servings = val;}
    public void setCalories(int val) {calories = val;}
    public void setFat(int val) {fat = val;}
    public void setSodium(int val) {sodium = val;}
    public void setCabohydrate(int val) {cabohydrate = val;}

}

/**
 * builder pattern
 */
class NutritionFacts3 {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int cabohydrate;

    public static class Builder {
        // required parameters
        private final int servingSize;
        private final int servings;

        // optional parameters : initialize
        private int calories= 0;
        private int fat= 0;
        private int sodium= 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val) {
            calories = val; return this;
        }
        public Builder fat(int val) {
            fat = val; return this;
        }
        public Builder sodium(int val) {
            sodium = val; return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val; return this;
        }

        public NutritionFacts3 build() {
            return new NutritionFacts3(this);
        }
    }

    private NutritionFacts3(Builder builder) {
        servingSize =  builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
































        sodium = builder.sodium;
        cabohydrate = builder.carbohydrate;

    }
}

/**
 * builder pattern example
 *
 */
abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();

        protected abstract T self();
    }

    // see item50
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;


        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }
        @Override
        protected Builder self() {
            return this;
        }

    }
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }
        @Override
        public Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
