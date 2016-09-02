package com.rodanandfields.utils;

import java.util.Random;

public class CommonUtilities {


		public static int getRandomNum(int min, int max) {
			return new Random().nextInt((max - min) + 1) + min;
		} 
	}

