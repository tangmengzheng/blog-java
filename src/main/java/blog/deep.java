package blog;

/**
 * Created by tangmengzheng on 2017/1/9.
 */
public class deep {
    // 递归获取客户下级客户，deep为递归查询的深度
//    public List<Cust> getChildCustList(String custId, int deep) {
//
//        if (deep <= 0) {
//            return null;
//        }
//
//        List<Cust> list = custMapper.getChildCustList(custId);
//
//        deep--;
//        if (deep <= 0) {
//            return list;
//        }
//
//        if (list != null && list.size() != 0) {
//            List<Cust> ts = new ArrayList<Cust>();
//            for (Cust cust : list) {
//                List<Cust> ls = getChildCustList(cust.getId(), deep);
//                if (ls != null && ls.size() != 0) {
//                    ts.addAll(ls);
//                }
//            }
//            if (ts != null && ts.size() != 0) {
//                list.addAll(ts);
//            }
//        }
//        return list;
//    }
}
