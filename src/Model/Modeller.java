/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.FlappyBird;
import static View.FlappyBird.HEIGHT;
import static View.FlappyBird.WIDTH;
import static View.FlappyBird.map1;
import static View.FlappyBird.map2;
import java.awt.Rectangle;

/**
 *
 * @author LinhNguyenDuc
 */
public class Modeller {

    private FlappyBird flappyBird;
    public int speed;

    public Modeller(FlappyBird flappyBird) {
        this.flappyBird = flappyBird;
    }

    //nhay
    public void jump() {
        flappyBird.fapSound.play();
        if (flappyBird.end) {//ket thuc va bat dau lai
 
            flappyBird.bird = new Rectangle(flappyBird.WIDTH / 3, flappyBird.HEIGHT / 2 - 150, 50, 50);//dat vi tri bird ban dau
            
            flappyBird.columns.clear();
            flappyBird.yMotion = 0;
            flappyBird.score = 0;
            flappyBird.vk_space = 0;

            flappyBird.model.addColumn(true);
            flappyBird.model.addColumn(true);
            flappyBird.model.addColumn(true);
            flappyBird.model.addColumn(true);

            flappyBird.end = false;
        }

        if (!flappyBird.start) {//bat dau choi
            flappyBird.start = true;
            flappyBird.themesong.play();
        } else if (!flappyBird.end) {// chua ket thuc
            if (flappyBird.yMotion > 0) {
                flappyBird.yMotion = 0;
                
            }
            flappyBird.yMotion -= 10;
        }
    }

    public void addColumn(boolean start) {
        int width = 100;
        int height = 50 + flappyBird.random.nextInt(300);
        int blank = 250;
        int space = 500 + flappyBird.random.nextInt(300);
        boolean a = flappyBird.random.nextBoolean();
        boolean b = flappyBird.random.nextBoolean();
        int blank1 = 200;
        if (start) {
                flappyBird.columns.add(new Rectangle(flappyBird.WIDTH + width + flappyBird.columns.size() * 400, flappyBird.HEIGHT - height - 150 , width, height));
                flappyBird.columns.add((new Rectangle(flappyBird.WIDTH + width + (flappyBird.columns.size() - 1) * 400, 0, width, flappyBird.HEIGHT - height - blank-150)));
        }
        else {
            if(a){
                if(b){
                    if(height >= 100 && height <=200){//cot 2 dau (0,...)
                        flappyBird.columns.add(new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x + space, flappyBird.HEIGHT - height - 150 - blank1, width, height));
                        flappyBird.columns.add((new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x, 0, width, flappyBird.HEIGHT - height - 2*blank1 - 150)));
                    }
                    else{
                        flappyBird.columns.add(new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x + space, flappyBird.HEIGHT - height - 150, width, height));
                        flappyBird.columns.add((new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x, 0, width, flappyBird.HEIGHT - height - blank -150)));
                    }
                }
                else{//bthg
                    if(height >= 100 && height <=200){//cot o giua
                        flappyBird.columns.add(new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x + space, flappyBird.HEIGHT - height - 150 - blank1, width, height));
                        flappyBird.columns.add((new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x, 0, width, 0)));
                    }
                    else{
                        flappyBird.columns.add(new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x + space, flappyBird.HEIGHT - height - 150, width, height));
                        flappyBird.columns.add((new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x, 0, width, flappyBird.HEIGHT - height - blank - 150)));
                    }
                }  
            }
            else{
                if(height >= 300){
                    height = 400;
                    if(b){//cot duoi
                        flappyBird.columns.add(new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x + space, flappyBird.HEIGHT - height - 150, width, height));
                        flappyBird.columns.add((new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x, 0, width, 0)));
                    }
                    else{//cot tren
                        flappyBird.columns.add(new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x + space, flappyBird.HEIGHT - 150, width, 0));
                        flappyBird.columns.add((new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x, 0, width, height)));
                    }
                }
                else{
                    flappyBird.columns.add(new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x + space, flappyBird.HEIGHT - height - 150, width, height));
                    flappyBird.columns.add((new Rectangle(flappyBird.columns.get(flappyBird.columns.size() - 1).x, 0, width, flappyBird.HEIGHT - height - blank -150)));
                }
            }
        }
    }

    public void birdFly() {
        if (flappyBird.pause_int == 4) {
            speed = 10;//toc do
            speed += (flappyBird.score/3);//tang toc do sau add 3 score
            flappyBird.tick++;
            if (flappyBird.start) {

                //dich chuyen cot
                for (Rectangle column : flappyBird.columns) {
                    column.x -= speed;
                }

                if (flappyBird.tick % 2 == 0 && flappyBird.yMotion < 20) {//bird roi xuong
                    flappyBird.yMotion += 2;
                    if(flappyBird.yMotion>0) flappyBird.vk_space = 2;
                }

                //add and remove column
                for (int i = 0; i < flappyBird.columns.size(); i++) {
                    Rectangle column = flappyBird.columns.get(i);
                    if (column.x + column.width < 0) {//di het man hinh
                        flappyBird.columns.remove(column);//remove column
                        if (column.y == 0) {//cot tren
                            flappyBird.model.addColumn(false);//add column
                        }
                    }
                }

                flappyBird.bird.y += flappyBird.yMotion;//bird roi xuong
                for (Rectangle column : flappyBird.columns) {
                    if (column.y == 0 && flappyBird.bird.x + flappyBird.bird.width / 2 >= column.x + column.width / 2 && flappyBird.bird.x + flappyBird.bird.width / 2 < column.x + column.width / 2 + speed) {
                        flappyBird.score+=flappyBird.a;//tang diem
                        flappyBird.getPointSound.play();
                    }
                    if (column.intersects(flappyBird.bird)) {//neu va cham
                        if (!flappyBird.end) {
                            flappyBird.fallSound.play();
                        }
                        flappyBird.end = true;

                        //bird chua qua column
                        if (flappyBird.bird.x <= column.x) {
                            flappyBird.bird.x = column.x - flappyBird.bird.width;//bi chan boi cot
                        }
                        else {//qua cot va cham phan tren      
                            //cot duoi
                            if (column.y != 0) {
                                flappyBird.bird.y = column.y - flappyBird.bird.height;//bird nam tren cot duoi
                            }
                            else if (flappyBird.bird.y < column.height) {
                                flappyBird.bird.y = column.height;//bird dinh len cot tren
                            }
                        }
                    }
                }
                if (flappyBird.bird.y > flappyBird.HEIGHT - 150 || flappyBird.bird.y < 0) {//cham dat or cham troi => ket thuc
                    if (!flappyBird.end) {
                        flappyBird.fallSound.play();
                    }

                    flappyBird.end = true;
                }

                if (flappyBird.bird.y + flappyBird.yMotion + flappyBird.bird.height >= flappyBird.HEIGHT - 150) {//roi ruong dat
                    flappyBird.bird.y = flappyBird.HEIGHT - 150 - flappyBird.bird.height;//nam tren mat dat
                    flappyBird.bird.x -= speed;
                    if (!flappyBird.end) {
                        flappyBird.fallSound.play();
                    }
                    flappyBird.end = true;
                }
            }
        }
    }
}
