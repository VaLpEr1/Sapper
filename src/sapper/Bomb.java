package sapper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixBombsCount();
    }

    void start(){
        bombMap = new Matrix(Box.zero);
        for (int j = 0; j < totalBombs; j++){
            placeBomb();
        }
    }

    Box get (Coord coord){
        return bombMap.get(coord);
    }

// Метод для установки количества бомб
    int getTotalBombs(){
        return totalBombs;
    }

// Метод фиксированного значения бомб, если они привышают значение
    private void fixBombsCount(){
        int maxBombs = (Ranges.getSize().x * Ranges.getSize().y) / 2;
        if(totalBombs > maxBombs){
            totalBombs = maxBombs;
        }
    }

// Метод для размещения бомб
    private void placeBomb(){
        while (true) {
            Coord coord = Ranges.getRandomCoord();
            if (Box.bomb == bombMap.get(coord)){
                continue;
            }
            bombMap.set(coord, Box.bomb);
            incNumbersAroundBomb(coord);
            break;
        }
    }

// Метод для проверки наличие бомбы в ячейке
    private void incNumbersAroundBomb(Coord coord) {
        for (Coord around : Ranges.getCoordAround(coord))
            if (Box.bomb != bombMap.get(around))
            bombMap.set(around, bombMap.get(around).nextNumberBox());
    }
}
