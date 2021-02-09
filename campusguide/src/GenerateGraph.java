public class GenerateGraph{
    public static final int INFINITY=Integer.MAX_VALUE;
    public static MatrixGraph<MessageNode> generateGraph() {
        MessageNode[] vexs= {new MessageNode("图文信息中心","A0" ,"图书馆是上海电力大学的地标性建筑，藏书众多" ),
                new MessageNode("一号公共教学楼","A1" ,"一号公共教学楼主要提供机房教室，师生可进行上机教学" ),
                new MessageNode("二号公共教学楼","A2" ,"二号公共教学楼主要为大二、大三学生提供上课教室" ),
                new MessageNode("三号公共教学楼","A3" ,"二号公共教学楼主要为大一学生提供上课教室" ),
                new MessageNode("能机学院","A4" ,"能机学院是能级学院学院楼，5层包括电气学院、自动化学院、体育部" ),
                new MessageNode("学术交流及学生事务中心","A5" ,"学术交流及学生事务中心是教务处、易班等学生教务中心，经常举办讲座活动" ),
                new MessageNode("二号食堂","A6" ,"二号食堂周边还有面包房、清真食堂等提供不同口味的饭菜，3层为工会" ),
                new MessageNode("学生活动中心","B0" ,"学生活动中心是学生举办各种舞台活动的地方" ),
                new MessageNode("电信/计算机学院","B1" ,"电信/计算机学院是电信学院和计算机学院的学院楼，有机房、实验室等" ),
                new MessageNode("数理学院","B2" ,"数理学院是数理学院的学院楼，内有两层物理实验室" ),
                new MessageNode("经管/外语/国交学院","B3" ,"经管/外语/国交学院是经管学院、外语学院、国交学院的学院楼" ),
                new MessageNode("环化学院","B4" ,"环化学院是环化学院的学院楼" ),
                new MessageNode("留学生/教师宿舍","B5" ,"留学生/教师宿舍" ),
                new MessageNode("学生公寓1","C1~4" ,"学生公寓1主要为大三、大四学生男寝、大二大三大四学生女寝" ),
                new MessageNode("学生公寓2","C5~9" ,"学生公寓2主要为大一大二学生男寝、大一女寝和研究生寝室" ),
                new MessageNode("一号食堂","C10" ,"一号食堂有三楼，一楼二楼主要为快餐，三楼为特色餐厅" ),
                new MessageNode("卫生所","C11" ,"卫生所" ),
                new MessageNode("综合体育馆","D1" ,"综合体育馆有三层，设有乒乓球场、排球馆等，负一楼为健身房" ),
                new MessageNode("体育场看台","D2" ,"体育场看台为露天体育场，可以观看体育比赛、体育表演等" ),
                new MessageNode("临港新校区建设指挥部","E1" ,"临港新校区建设指挥部是校区建设指挥部" ),
                new MessageNode("创新创业工程训练中心","E2" ,"创新创业工程训练中心是学生进行工程实训的地方" ),
                new MessageNode("能源中心/动力馆","E3" ,"能源中心/动力馆是学校的能源管控中心" ),
        };

        Triple edge[]= {
                new Triple(0,1,372),new Triple(0,2,193),new Triple(0,3,171),new Triple(0,4,442),new Triple(0,5,127),new Triple(0,6,397),new Triple(0,7,679),new Triple(0,10,1152),new Triple(0,11,1753),new Triple(0,12,1548),new Triple(0,19,794),
                new Triple(1,0,372),new Triple(1,2,73),new Triple(1,3,236),new Triple(1,4,999),new Triple(1,13,236),new Triple(1,15,563),new Triple(1,17,468),new Triple(1,18,503),new Triple(1,19,628),new Triple(1,20,980),new Triple(1,21,1006),
                new Triple(2,0,193),new Triple(2,1,73),new Triple(2,3,56),new Triple(2,13,113),new Triple(2,15,168),
                new Triple(3,0,171),new Triple(3,1,236),new Triple(3,2,56),new Triple(3,6,603),new Triple(3,7,393),new Triple(3,13,399),new Triple(3,15,80),new Triple(3,16,674),
                new Triple(4,0,442),new Triple(4,1,999),new Triple(4,5,68),new Triple(4,19,1577),new Triple(4,20,1123),new Triple(4,21,1276),
                new Triple(5,0,127),new Triple(5,4,68),new Triple(5,6,93),
                new Triple(6,0,397),new Triple(6,3,603),new Triple(6,5,93),new Triple(6,10,1234),new Triple(6,11,983),new Triple(6,12,1192),
                new Triple(7,0,679),new Triple(7,3,393),new Triple(7,8,199),new Triple(7,10,498),new Triple(7,14,293),new Triple(7,15,472),new Triple(7,16,167),
                new Triple(8,7,199),new Triple(8,9,133),new Triple(8,10,368),new Triple(8,14,169),
                new Triple(9,8,133),new Triple(9,10,265),new Triple(9,14,325),
                new Triple(10,0,1152),new Triple(10,6,1234),new Triple(10,7,498),new Triple(10,8,368),new Triple(10,9,265),new Triple(10,11,212),new Triple(10,12,598),
                new Triple(11,0,1753),new Triple(11,6,983),new Triple(11,10,212),new Triple(11,12,177),
                new Triple(12,0,1548),new Triple(12,6,1192),new Triple(12,10,598),new Triple(12,11,177),
                new Triple(13,1,236),new Triple(13,2,113),new Triple(13,3,399),new Triple(13,15,76),new Triple(13,17,283),new Triple(13,18,203),
                new Triple(14,7,293),new Triple(14,8,169),new Triple(14,9,325),new Triple(14,16,75),
                new Triple(15,1,563),new Triple(15,2,168),new Triple(15,3,80),new Triple(15,7,472),new Triple(15,13,76),new Triple(15,16,193),
                new Triple(16,3,674),new Triple(16,7,167),new Triple(16,14,75),new Triple(16,15,193),
                new Triple(17,1,468),new Triple(17,13,283),new Triple(17,18,60),new Triple(17,19,783),
                new Triple(18,1,503),new Triple(18,13,203),new Triple(18,17,60),new Triple(18,19,487),
                new Triple(19,0,794),new Triple(19,1,628),new Triple(19,4,1577),new Triple(19,17,783),new Triple(19,18,487),new Triple(19,20,65),new Triple(19,21,287),
                new Triple(20,1,980),new Triple(20,4,1123),new Triple(20,19,65),new Triple(20,21,136),
                new Triple(21,1,1006),new Triple(21,4,1276),new Triple(21,19,287),new Triple(21,20,136)
        };
        MatrixGraph<MessageNode> G=new MatrixGraph<>(vexs,edge);
        return G;
    }
}