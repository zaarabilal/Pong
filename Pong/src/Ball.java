public class Ball {



private int height;
private int width;
private int x;
private int y;
private int dy;
private int dx;
private boolean moveup;
private boolean moveright;


public Ball() {

height=15;
width= 15;
x=400;
y=300;
dy=0;
dx=0;
moveup=false;
moveright=false;


}

public Ball(int posx, int posy) {
	x=posx;
	y=posy;
	//dy=2;
	//dx=2;
	moveup=false;
	moveright=false;
	height=30;
	width= 30;
}

public void reset() {
x=400;
y=300;
dx=0;
dy=0;

}
public int getX() {
	return x;
}


public int getY() {
	return y;
}
public int getW() {
	return width;
}
public int getH() {
	return height;
}
public void setMoveup() {
	moveup=!moveup;
}
public void setMovert() {
	moveright=!moveright;
}
public void setdx(int newdx) {
	dx=newdx;
}
public void setdy(int newdy) {
	dy=newdy;
}
//collision with paddle 2
public boolean collisionp2(Paddle p) {
	if(getX()+getW()>=p.getX()&&getY()<=p.getY()+p.getHeight()&&getY()+getH()>=p.getY()) {
		setMovert();
		return true;
	}
	return false;
}
//collision with paddle 1
public boolean collisionp1(Paddle p1) {
	if (getX()<=p1.getX()+p1.getWidth()&&getY()<=p1.getY()+p1.getHeight()&&getY()+ getH()>=p1.getY()) {
		setMovert();
        return true;
}
return false;
}
/*public String getBackground() {
	return background;
}*/
public void move()
{
	if(moveup) {
		y-=dy;
	}
	else {
		y+=dy;
	}
	if(moveright) {
		x+=dx;
	}
	else {
		x-=dx;
	}
	if(y<=0||y>=500) {
		setMoveup();
	}
	//DELETE AFTER COLLISION
	
	
	
		
	/*System.out.println("x="+x);
	if (x>540 || x<-130) {
		reverse=!reverse;
	}

	if (reverse)
	{
		x-=dx;
	}
	else
	{
		x+=dx;
	}
	System.out.println ("y="+y);
	if (y>410 || y<-30) {
		reversey=!reversey;
	}
	if (reversey) {
		y-=dy;
	}
	else {
		y+=dy;
	}
	System.out.println("x2="+x2);
	if (x2>530 || x2<-120) {
		reverse2=!reverse2;
	}

	if (reverse2)
	{
		x2--;
	}
	else
	{
		x2++;
	}
	System.out.println ("y2="+y2);
	if (y2>405 || y2<-20) {
		reversey2=!reversey2;
	}
	if (reversey2) {
		y2--;
	}
	else {
		y2++;
	}*/

}

}


