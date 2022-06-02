//region выстрел (игрока или компьютера)
  /*          if (currentPlayer == Player.COMP) {
                    System.out.println("Выстрел компьютера. Для продолжения нажмите <Enter>");
                    new Scanner(System.in).nextLine();

                    int iShoot, jShoot;

                    do {
                    iShoot = random.nextInt(filedSize);
                    jShoot = random.nextInt(filedSize);
                    } while (userField[iShoot][jShoot] == FieldCell.DEAD_SHIP || userField[iShoot][jShoot] == FieldCell.MISS);

                    if (userField[iShoot][jShoot] == FieldCell.EMPTY) {
                    userField[iShoot][jShoot] = FieldCell.MISS;
                    currentPlayer = Player.USER;
                    } else if (userField[iShoot][jShoot] == FieldCell.ALIVE_SHIP) {
                    userField[iShoot][jShoot] = FieldCell.DEAD_SHIP;
                    countUserShips--;
                    }
                    } else if (currentPlayer == Player.USER) {
                    System.out.println("Выстрел игрока");

                    //ДЗ доделать проверку адекватного выстрела игрока (границы массива, не туда выстрелил и тд)

                    Scanner scanner = new Scanner(System.in);
                    int iShoot, jShoot;
                    System.out.print(String.format("введите строчку для выстрела от %d до %d: ", 1, filedSize));
                    iShoot = scanner.nextInt() - 1;

                    System.out.print(String.format("введите столбец для выстрела от %d до %d: ", 1, filedSize));
                    jShoot = scanner.nextInt() - 1;

                    if (compField[iShoot][jShoot] == FieldCell.EMPTY) {
                    compField[iShoot][jShoot] = FieldCell.MISS;
                    currentPlayer = Player.COMP;
                    } else if (compField[iShoot][jShoot] == FieldCell.ALIVE_SHIP) {
                    compField[iShoot][jShoot] = FieldCell.DEAD_SHIP;
                    countCompShips--;
                    }
                    }
//endregion*/