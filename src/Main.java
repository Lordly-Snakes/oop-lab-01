//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> в поле.

class Point{
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int x;
    public int y;
}

abstract class Movable {
    void move(Point p1,Point p2){
        System.out.printf("%nГерой перемещается из точки (%d;%d) в точку (%d:%d)%n",p1.x,p1.y,p2.x,p2.y);
    }
}

class MoveBasic extends Movable {
    @Override
    public void move(Point p1, Point p2) {
        super.move(p1,p2);
        System.out.print("Пешком");
    }
}


class MoveOnHorse extends Movable {
    @Override
    public void move(Point p1, Point p2) {
        super.move(p1,p2);
        System.out.print("на лошади");
    }
}

class MoveFly extends Movable {
    @Override
    public void move(Point p1, Point p2) {
        super.move(p1,p2);
        System.out.print("с помощью полета");
    }
}

class Hero{
    private Movable _moveStrategy;
    public  Hero(Movable moveStrategy){
        setMoveStrategy(moveStrategy);
    }

    public void setMoveStrategy(Movable moveStrategy){
        _moveStrategy = moveStrategy;
    }

    public void move(Point p1, Point p2){
        _moveStrategy.move(p1,p2);
    }
}

class Program{
    public static void main() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        Hero alladin = new Hero(new MoveFly());
        alladin.move(p1,p2);

        alladin.setMoveStrategy(new MoveBasic());
        alladin.move(p1,p2);


        alladin.setMoveStrategy(new MoveOnHorse());
        alladin.move(p1,p2);
        // TO DO написать меню выбора
    }
}



