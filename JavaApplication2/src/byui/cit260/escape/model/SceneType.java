/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.model;

import java.io.Serializable;

/**
 *
 * @author ryanjoos
 */
public enum SceneType implements Serializable {

    start("Start scene", "ST"),
    finish("Finish Scene", "END"),
    beach("Beach scene", "***"),
    river("River scene", ">>>"),
    cliff("Cliff scene", "^^^"),
    volcano("Volcano Scene", "/^\\"),
    jungle("Jungle scene", "###"),
    timber("Timber resource scene", "$$$"),
    grain("Grain resource scene", "%%%"),
    ocean("Ocean scene", "~~~"),
    running("running scene", "!!!"),
    bridge("Bridge scene", "==="),
    grass("Grass scene", ":::");

    private final String description;
    private final String mapSymbol;

    SceneType(String description, String mapSymbol) {
        this.description = description;
        this.mapSymbol = "???";
    }

    public String getDescription() {
        return description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }
}
