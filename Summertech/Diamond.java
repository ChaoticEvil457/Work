package Summertech;

public class Diamond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int o=0;o<20; o++){

			for(int w=20;w>o;w--){
				System.out.print(" ");

			}

			for(int y=0;y<o;y++){
				System.out.print("* ");

			}
			System.out.println();

		}

		for(int o=20;o>0; o--){

			for(int w=20;w>o;w--){
				System.out.print(" ");

			}

			for(int y=0;y<o;y++){
				System.out.print("* ");

			}
			System.out.println();

		}
	}

}