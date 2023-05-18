package logic;

import java.util.ArrayList;

import character.Balloon;
import character.Entity;
import character.Monkey;

public class Utility {

	public static double getObjectDistance(Entity obj1, Entity obj2) {
		return Math.sqrt(Math.pow(obj1.x - obj2.x, 2)
				+ Math.pow(obj1.y - obj2.y, 2));
	}

	public static double turningDegree(Entity obj1, Entity obj2) {
		double deltaX = obj2.x - obj1.x;
		double deltaY = obj2.y - obj1.y;

		return Math.toDegrees(Math.atan2(deltaY, deltaX));
		
	}

	public static boolean isBalloonInRange(Entity obj, Balloon balloon) {
		
		if (obj instanceof Monkey) {
			return getObjectDistance(obj, balloon) <= Monkey.ATKRANGE;
		}
		
		return false;
	}

	public static ArrayList<Balloon> getBalloonInRange(Monkey tower) {

		ArrayList<Balloon> balloons = new ArrayList<Balloon>();
		for (Balloon balloon : GameLogic2.balloonInField) {
			if (isBalloonInRange(tower, balloon)) {
				balloons.add(balloon);
			}
		}

		return balloons;
	}

	public static Balloon getNearestBalloon(Monkey tower) {

		int index = -1;
		double minValue = -1;

		ArrayList<Balloon> balloonsInRange = getBalloonInRange(tower);

		for (int i = 0; i < balloonsInRange.size(); i++) {
			if (getObjectDistance(tower, balloonsInRange.get(i)) <= minValue) {
				index = i;
				minValue = getObjectDistance(tower, balloonsInRange.get(i));
			}
		}

		return balloonsInRange.get(index);
	}

}
