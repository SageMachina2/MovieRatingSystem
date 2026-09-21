import java.util.Scanner;

public class MovieRatingSystem
{
    
    public static void main(String[] args) 
    {
        //initate scanner
        Scanner scn = new Scanner(System.in);
        //initiate parallel arrays for movies and ratings
        String[] movies = new String[5];
        int[] ratings = new int[5];
        int totalRatings = 0;

        //collects user input for name, uses nextLine() to allow for spaces in the name
        System.out.println("Enter your name: ");
        String name = scn.nextLine();

        //collects user input for movies and ratings. 
        //Continues to prompt user until movie int reaches the max of 5
        for (int i = 0; i < movies.length; i++) {
        System.out.println("Enter movie " + (i + 1) + ": ");
        movies[i] = scn.nextLine();

        int rating = 0;
        // Keep asking until the user enters an integer from 1 to 10.
        while (rating < 1 || rating > 10) {
            System.out.print("Rate this movie from 1 to 10: ");
            
            if (scn.hasNextInt()) {
                rating = scn.nextInt();
                if (rating < 1 || rating > 10) {
                    System.out.println(
                        "Invalid rating. Enter a number from 1 to 10."
                        );
                    }
            } 
            else {
                System.out.println(
                "Invalid input. Please enter a whole number."
        );
    }
    // Remove the number or invalid text, including the Enter key.
    scn.nextLine();
    }
        // Stores the rating and adds it to the total ratings for average calculation
        ratings[i] = rating;
        totalRatings += rating;
    }

    // Calculates average ratin
    double averageRating = (double) totalRatings / movies.length;

    System.out.println();
    System.out.println(name + "'s average rating is " + averageRating);

    // Provides feedback messages based on the average rating using if else statements.
    if (averageRating >= 9) {
        System.out.println("You are a cinephile!");
    } else if (averageRating >= 7) {
        System.out.println("You enjoy movies quite a bit.");
    } else if (averageRating >= 5) {
        System.out.println("You have mixed feelings about movies.");
    } else {
        System.out.println("You are a tough critic!");
    }

    // tracks if user has rated a movie as 10 (favorite) or less than 4 (worst)
    boolean favorite = false;
    boolean worst = false;

    for (int rating : ratings) {
        if (rating == 10) {
            favorite = true;
        }
        if (rating < 4) {
            worst = true;
        }
    }

    // Prints messages based on favorites and worst ratings
    if (favorite || worst) {
    if (favorite) {
        System.out.println(
            "Wow! You found a masterpiece."
        );
    }

    if (worst) {
        System.out.println(
            "That movie didn't impress you much."
        );
    }
    }
    // checks if every rates is either higher than 7 or lower than 3 to calcuate the user's average enjoyment of movies
    boolean goodRating = true;
    boolean badRating = false;

    for (int rating : ratings) {
        goodRating =
            goodRating && (rating >= 7);

        badRating =
            badRating || (rating < 3);
    }

    if (goodRating) {
        System.out.println("You seem to enjoy most movies.");
    }
    if (badRating) {
        System.out.println("You have strong opinions on movies!");
    }

        // Asks user for their favorite genre and provides a message based on their choice
        System.out.println("");
        System.out.println("Choose a favorite genre: Action, Comedy, Horror, Drama, or Sci-Fi"
        );
        System.out.print("Genre: ");

        String genre = scn.nextLine().trim();
        // Uses a switch statement and cases to provide a message based on the user's chosen genre.
        switch (genre.toLowerCase()) {
            case "action":
                System.out.println("You love excitement and thrills!");
                break;
            case "comedy":
                System.out.println("You enjoy a good laugh.");
                break;
            case "horror":
                System.out.println("You have a taste for fear!");
                break;
            case "drama":
                System.out.println("You appreciate deep storytelling.");
                break;
            case "sci-fi":
                System.out.println("You love futuristic and imaginative worlds!");
                break;
            default:
                System.out.println("That genre was not on the list.");
        }
    // Checks if user chose Sci-Fi and provides a corresponding movie reccommendation based on their choice
    boolean choseSciFi =
    genre.equalsIgnoreCase("Sci-Fi")
        || genre.equalsIgnoreCase("Sci Fi");

    String recommendation = choseSciFi ? "Interstellar" : "The Dark Knight";

    System.out.println(
        "Movie recommendation: " + recommendation
    );
    // scanner close
    scn.close();
    }
}
