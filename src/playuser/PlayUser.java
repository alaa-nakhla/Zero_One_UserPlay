package playuser;

import java.util.Scanner;

public class PlayUser {

    public static class Patch {

        int n, m;
        int[][] p;

        Patch() {
            int[][] p1 = {{0, 1, 0}, {1, 2, 1}, {0, 5, 0}};
            int[][] p2 = {{5, 5, 3}, {4, 0, 2}, {9, 2, 2}};
            int[][] p3 = {{2, 1, 1}, {1, 2, 1}, {1, 1, 0}};
            int[][] p4 = {{4, 6, 7, 1}, {0, 6, 6, 0}, {0, 6, 4, 4}};
            int[][] p5 = {{4, 6, 7, 1}, {0, 6, 6, 0}, {0, 6, 4, 4}};
            int[][] p6 = {{0, 0, 1, 0, 0}, {0, 1, 1, 9, 0}, {1, 5, 6, 1, 1}};
            int[][] p7 = {{2, 1, 2, 1}, {0, 1, 0, 0}, {1, 1, 5, 4}, {0, 0, 1, 0}, {1, 7, 8, 3}};
            int[][] p8 = {{2, 1, 2, 1}, {0, 1, 0, 0}, {1, 1, 5, 4}, {0, 1, 0, 0}, {1, 7, 8, 3}};
            int[][] p9 = {{0, 0, 1, 0, 0}, {0, 2, 1, 6, 0}, {2, 2, 0, 4, 1}, {0, 2, 1, 1, 0}, {0, 0, 5, 0, 0}};
            int[][] p10 = {{4, 5, 5, 4, 1}, {1, 0, 1, 0, 0}, {1, 0, 9, 1, 6}, {1, 0, 0, 0, 5}, {1, 1, 1, 5, 4}};
            int[][] p11 = {{2, 2, 2, 0, 0, 0}, {2, 0, 5, 0, 0, 0}, {2, 0, 5, 5, 5, 5}, {2, 0, 5, 0, 0, 2}, {2, 2, 2, 2, 2, 2}};
            int[][] p12 = {{0, 0, 1, 2, 0, 0}, {1, 1, 8, 3, 1, 1}, {1, 0, 1, 2, 0, 1}, {1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {2, 1, 0, 0, 4, 5}, {1, 0, 0, 0, 0, 4}};
            p = p1;
            n = p.length;
            m = p[0].length;
            System.out.println("start Game");
            show();
        }

        Position clacPos(int i, int j, char d) {
            Position p2 = new Position();
            if (d == 'r') {
                p2.i = i;
                p2.j = j + 1;
            } else if (d == 'l') {
                p2.i = i;
                p2.j = j - 1;
            } else if (d == 'u') {
                p2.j = j;
                p2.i = i - 1;
            } else if (d == 'd') {
                p2.j = j;
                p2.i = i + 1;
            } else {
                p2.j = j;
                p2.i = i;
            }
            return p2;
        }

        int Sum() {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sum += p[i][j];
                }
            }
            return sum;
        }

        public boolean canMove(int x, int y, char d) {
            if (x < n && x > -1 && y > -1 && y < m && clacPos(x, y, d).i < n && clacPos(x, y, d).i > -1 && clacPos(x, y, d).j > -1 && clacPos(x, y, d).j < m) {
                if (p[x][y] > 0 && p[clacPos(x, y, d).i][clacPos(x, y, d).j] > 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean move(int x, int y, char d) {
            if (canMove(x, y, d)) {
                if (p[x][y] == p[clacPos(x, y, d).i][clacPos(x, y, d).j]) {
                    p[x][y] = p[clacPos(x, y, d).i][clacPos(x, y, d).j] = 0;
                } else {
                    p[clacPos(x, y, d).i][clacPos(x, y, d).j] += p[x][y];
                    p[x][y] = 0;
                }
                winer();
                show();
                return true;
            }
            return false;
        }

        public void show() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (p[i][j] == 0) {
                        System.out.print("|▩");
                        continue;
                    }
                    System.out.print("|" + p[i][j]);
                }
                System.out.print("|\n");
            }
            System.out.println("");
        }

        public boolean winer() {
            int sum = this.Sum();
            if (sum == 0) {
                System.out.println("YOU WIN");
                return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Patch p1 = new Patch();
        while (p1.Sum() != 0) {
            System.out.print("x1:");
            int x1 = input.nextInt();
            System.out.print("y1:");
            int y1 = input.nextInt();
            System.out.print("d:");
            char d = input.next().charAt(0);
            p1.move(x1, y1, d);
        }
    }

}
