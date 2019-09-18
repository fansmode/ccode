import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3232 {

    static final int PROV_LEVEL = 0;
    static final int CITY_LEVEL = 1;
    static final int COUNTY_LEVEL = 2;
    static final int VILLAGE_LEVEL = 3;

    static final String REGEX = "(?<prov>[^省]+省)*(?<city>[^市]+市)(?<county>.+区)?(?<village>.*)";

    static Map<String, Addr> addrMap = new HashMap<>();

    public static void main(String[] args) {
        String input1 = "浙江省杭州市西湖区蒋村街道";
        String input2 = "浙江省杭州市西湖区留存街道";
        String input3 = "浙江省杭州市灵隐区2街道";
        String input4 = "北京市朝阳区三里屯街道";
        String input6 = "北京市朝阳区四里屯街道";
        String input5 = "北京市海淀区2街道";
        handle(input1);
        handle(input2);
        handle(input3);
        handle(input4);
        handle(input5);
        handle(input6);
        String searchKey = "朝阳区";

        if (addrMap.containsKey(searchKey)) {
            Addr addr = addrMap.get(searchKey);
            printParent(addr);
            if (addr.level == VILLAGE_LEVEL) {
                System.out.println(searchKey);
            } else if (addr.level == COUNTY_LEVEL) {
                System.out.print(searchKey + ":");
                printChildOfCounty(addr);
            } else if (addr.level == CITY_LEVEL) {
                System.out.println(searchKey);
                printChildsOfCity(addr);
            } else {
                System.out.println(searchKey);
                printChildsOfProv(addr);
            }

        }

    }

    private static void handle(String address) {
        Matcher m = Pattern.compile(REGEX).matcher(address);
        String[] addr = new String[4];
        while (m.find()) {
            addr[0] = m.group("prov");
            addr[1] = m.group("city");
            addr[2] = m.group("county");
            addr[3] = m.group("village");
        }
        Addr tempAddr;
        for (int i = 0, length = addr.length; i < length; i++) {
            if (addr[i] != null) {
                if (addrMap.containsKey(addr[i])) {
                    tempAddr = addrMap.get(addr[i]);
                    if (i < 3) {
                        tempAddr.childs.add(addr[i + 1]);
                    }
                } else {
                    tempAddr = new Addr();
                    tempAddr.level = i;
                    if (i != 0) {
                        tempAddr.parent = addr[i - 1];
                    }
                    if (i < 3) {
                        tempAddr.childs.add(addr[i + 1]);
                    }
                    addrMap.put(addr[i], tempAddr);
                }

            }
        }
    }

    private static void printParent(Addr addr) {
        String par = addr.parent;
        if (par == null) {
            return;
        }
        if (addrMap.containsKey(par)) {
            printParent(addrMap.get(par));
        }
        System.out.println(par);
    }

    private static void printChildsOfProv(Addr addr) {
        for (String child : addr.childs) {
            System.out.println(child);
            Addr t = addrMap.get(child);
            if (t != null) {
                printChildsOfCity(t);
            }
        }
    }

    private static void printChildsOfCity(Addr addr) {
        for (String child : addr.childs) {
            System.out.print(child + ":");
            Addr t = addrMap.get(child);
            if (t != null) {
                printChildOfCounty(t);
            }
        }
    }

    private static void printChildOfCounty(Addr addr) {
        Set<String> chil = addr.childs;
        int size = chil.size();
        int i = 0;
        for (String s : chil) {
            i++;
            System.out.print(s);
            if (i < size) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }


}

class Addr {
    int level;
    String parent;
    Set<String> childs = new HashSet<>();
}
