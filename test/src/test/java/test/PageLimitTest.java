/// ****/
// package test;
//
// import java.util.List;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import com.js.bean.MemberBean;
// import com.js.core.dao.Limit;
// import com.js.core.util.BeanListSpringUtil;
// import com.js.core.util.CollectionUtils;
// import com.js.core.util.PagePagination;
// import com.js.dao.member.mapper.MemberMapper;
// import com.js.dao.member.model.Member;
// import com.js.dao.member.model.MemberExample;
//
/// *****
// *
// * @author oa_wenzongyuan
// */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:/spring/application-context.xml")
// public class PageLimitTest {
//
// @Autowired
// private MemberMapper c_MemberMapper;
//
// // 添加数据
// @Test
// public void pageLimitTest() {
// Member member = new Member();
// member.setName("母鸡啊");
// member.setAge(40l);
// c_MemberMapper.insertSelective(member);
// System.out.println("添加完成！");
// }
//
// // 分页测试（查询数据）
// @Test
// public void pageLimitTest1() throws InstantiationException, IllegalAccessException {
// MemberExample example = new MemberExample();
// MemberExample.Criteria criteria = example.createCriteria();
// example.setOrderByClause("age desc");
// // 查询总条数
// c_MemberMapper.countByExample(example);// 可以独立出来提高代码复用性
// // 分页（参数为页面尺寸和起始页码）
// PagePagination ppg = new PagePagination(2, 1);
// Limit limit = new Limit(ppg.getStartIndex(), ppg.getMaxRows());
// example.setLimit(limit);
// // 执行查询
// List<Member> list = c_MemberMapper.selectByExample(example);
// if (CollectionUtils.isEmpty(list)) {
// System.out.println("查询结果为空");
// } else {
// List<MemberBean> BeanList = BeanListSpringUtil.getList(list, MemberBean.class);
// System.out.println("当页条数：" + BeanList.size());
// for (MemberBean mb : BeanList) {
// System.out.println(mb.toString());
// System.out.println(" ");
// }
// }
//
// }
// }
