package dev.ose20.arknigthstoolui.util;

import dev.ose20.arknigthstoolui.dto.Material;
import dev.ose20.arknigthstoolui.dto.RequiredMaterial;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MaterialUtils {
    private MaterialUtils() {}

    public static List<RequiredMaterial> calculateNeededMaterials(Selection<Material> selection) {
        Map<Long, Integer> resultMp = new HashMap<>();

        /* Todo:
            (id, count) を使う
            idのレシピを中級換算まで遡る
            全部に *= count して、resultMp に登録
            すべてのエントリに対して行う
            resultMp を List<RequiredMaterial> の形にして return

         */

        // これらのロジック、api側で実装するってのもありかも

        return null;
    }

    private static Map<Long, Integer> calcMaterialsById(Long id) {
        Map<Long, Integer> res = new HashMap<>();
        /* Todo:
            p
        */

        return null;
    }
}
