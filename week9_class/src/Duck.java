public abstract class Duck {
    private QuackMode quackMode;
    private FlyMode flyMode;

    public void setFlyMode(String flyMode) {
        if (flyMode.equals("CanFly")) {
            this.flyMode = new CanFly();
        }
        else {
            this.flyMode = new CannotFly();
        }
    }

    public void setQuackMode(String quackMode) {
        if (quackMode.equals("Quack")) {
            this.quackMode = new Quack();
        }
        else if (quackMode.equals("Squeak")) {
            this.quackMode = new Squeak();
        }
        else {
            this.quackMode = new Silent();
        }
    }

    public FlyMode getFlyMode() {
        return flyMode;
    }

    public QuackMode getQuackMode() {
        return quackMode;
    }
    public abstract void swim();
}
