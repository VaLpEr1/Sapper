package sapper;

class Matrix {

    private Box[] [] matrix;

    Matrix(Box box){
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y];
        for (Coord coord : Ranges.getAllCoords())
            matrix [coord.x][coord.y] = box;
    }

// Метод гетер для получения значения полей игры
    Box get (Coord coord){
        if (Ranges.inRange(coord)){
            return matrix [coord.x] [coord.y];
        }else {
            return null;
        }
    }

// Метод сетор который устанавливает значения полей игры
    void set(Coord coord, Box box){
        if (Ranges.inRange(coord))
            matrix [coord.x] [coord.y] = box;
    }
}
