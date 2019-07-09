package WeeklyContest144;

public class DefangingAnIpAddress {

    public String defangIPaddr(String address) {
        StringBuilder defangIPaddr = new StringBuilder();
        for (int i = 0; i < address.length(); ++i) {
            if (address.charAt(i) == '.') {
                defangIPaddr.append("[.]");
            } else {
                defangIPaddr.append(address.charAt(i));
            }
        }
        return defangIPaddr.toString();
    }
}
