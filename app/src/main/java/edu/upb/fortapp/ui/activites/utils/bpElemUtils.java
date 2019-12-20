package edu.upb.fortapp.ui.activites.utils;

import java.util.ArrayList;
import java.util.List;

import edu.upb.fortapp.R;

public class bpElemUtils {

    public static List<bpElemMock> getBattlePassElements() {
        List<bpElemMock> battlePassElements = new ArrayList<>();
        battlePassElements.add(new bpElemMock(1, 1,R.drawable.bp1, "1000 V-Bucks"));
        battlePassElements.add(new bpElemMock(2, 2,R.drawable.bp2, "Raptor"));
        battlePassElements.add(new bpElemMock(3, 3,R.drawable.bp1, "1000 V-Bucks"));
        battlePassElements.add(new bpElemMock(4, 4,R.drawable.bp3, "John Wick"));
        battlePassElements.add(new bpElemMock(5, 5,R.drawable.bp1, "1000 V-Bucks"));
        battlePassElements.add(new bpElemMock(6, 6,R.drawable.bp4, "Royale Bomber"));
        battlePassElements.add(new bpElemMock(7, 7,R.drawable.bp1, "1000 V-Bucks"));
        battlePassElements.add(new bpElemMock(8, 8,R.drawable.bp5, "Flare"));
        battlePassElements.add(new bpElemMock(9, 9,R.drawable.bp1, "1000 V-Bucks"));
        battlePassElements.add(new bpElemMock(10, 10,R.drawable.bp6, "Absolute Zero"));
        return battlePassElements;
    }
}
