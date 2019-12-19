package edu.upb.fortapp.ui.activites.utils;

import java.util.ArrayList;
import java.util.List;

import edu.upb.fortapp.R;

public class bpElemUtils {

    public static List<bpElemMock> getBattlePassElements() {
        List<bpElemMock> battlePassElements = new ArrayList<>();
        battlePassElements.add(new bpElemMock(1, 1,R.drawable.bp1, "Nombre Premio1"));
        battlePassElements.add(new bpElemMock(2, 2,R.drawable.bp1, "Nombre Premio2"));
        battlePassElements.add(new bpElemMock(3, 3,R.drawable.bp1, "Nombre Premio3"));
        battlePassElements.add(new bpElemMock(4, 4,R.drawable.bp1, "Nombre Premio4"));
        battlePassElements.add(new bpElemMock(5, 5,R.drawable.bp1, "Nombre Premio5"));
        battlePassElements.add(new bpElemMock(6, 6,R.drawable.bp1, "Nombre Premio6"));
        battlePassElements.add(new bpElemMock(7, 7,R.drawable.bp1, "Nombre Premio7"));
        battlePassElements.add(new bpElemMock(8, 8,R.drawable.bp1, "Nombre Premio8"));
        battlePassElements.add(new bpElemMock(9, 9,R.drawable.bp1, "Nombre Premio9"));
        battlePassElements.add(new bpElemMock(10, 10,R.drawable.bp1, "Nombre Premio10"));
        return battlePassElements;
    }
}
