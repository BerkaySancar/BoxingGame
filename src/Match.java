public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {
        if (isCheck()) {
            switch (firstDamage()) {
                case 1:
                    System.out.println(this.f1.name + " started !");

                    while (this.f1.health > 0 && this.f2.health > 0) {
                        System.out.println("-----------NEW ROUND-------------");

                        this.f2.health = this.f1.hit(this.f2);
                        if (isWin()) {
                            break;
                        }
                        this.f1.health = this.f2.hit(this.f1);
                        if (isWin()) {
                            break;
                        }
                        System.out.println(this.f1.name + " Healt = " + this.f1.health);
                        System.out.println(this.f2.name + " Healt = " + this.f2.health);
                    }
                    break;
                case 2:
                    System.out.println(this.f2.name + " started !");
                    while (this.f1.health > 0 && this.f2.health > 0) {
                        System.out.println("-----------NEW ROUND-------------");

                        this.f1.health = this.f2.hit(this.f1);
                        if (isWin()) {
                            break;
                        }
                        this.f2.health = this.f1.hit(this.f2);
                        if (isWin()) {
                            break;
                        }
                        System.out.println(this.f1.name + " Healt = " + this.f1.health);
                        System.out.println(this.f2.name + " Healt = " + this.f2.health);
                    } break;
            }
        } else {
            System.out.println("The weights of the fighters are incompatible !");
        }
    }

    int firstDamage() {
        double random = Math.random() * 100;
        if (random > 50.0) {
            return 1;
        } else {
            return 2;
        }
    }

    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " WIN !");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " WIN !");
            return true;

        }
        return false;
    }
}
