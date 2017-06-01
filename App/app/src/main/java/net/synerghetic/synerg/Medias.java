package net.synerghetic.synerg;

/**
 * Created by aude on 01/06/2017.
 */

public class Medias {

    private final String input;

        public Medias(String input) {
            this.input = input;
        }

        // not needed but implemented for completeness
        public static Medias parse(String input) {
            return new Medias(input);
        }

}
