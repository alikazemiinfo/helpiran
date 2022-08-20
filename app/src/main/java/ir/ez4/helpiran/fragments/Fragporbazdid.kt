package ir.ez4.helpiran.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.ez4.helpiran.MainActivity2
import ir.ez4.helpiran.R
import ir.ez4.helpiran.adaptors.Itemevent
import ir.ez4.helpiran.adaptors.porbazdidadaptor
import ir.ez4.helpiran.data.Itempost
import ir.ez4.helpiran.databinding.FragmentPorbazdidBinding

const val SENDING_DATA_WITH_INTENTTOMAINACTIVITY_INORDERTOSHOWOURCONTENT="SendData"

class Fragporbazdid:Fragment(),Itemevent {

    lateinit var binding: FragmentPorbazdidBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentPorbazdidBinding.inflate(layoutInflater,container,false)

        return binding.root


    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val extendedFloatingActionButton =binding.extFabPortrafdar
        val extendedFloatingActionButton2=binding.ext2FabPortrafdar

        val nestedScrollView = binding.rcyclePorbazdid

        extendedFloatingActionButton.isNestedScrollingEnabled=false
        extendedFloatingActionButton2.isNestedScrollingEnabled=false

        view.findViewById<RecyclerView>(R.id.rcycle_porbazdid).setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY > oldScrollY + 12 && extendedFloatingActionButton.isExtended && extendedFloatingActionButton2.isExtended) {
                extendedFloatingActionButton.shrink()
                extendedFloatingActionButton2.shrink()

            }

            // the delay of the extension of the FAB is set for 12 items
            if (scrollY < oldScrollY - 12 && !extendedFloatingActionButton.isExtended && !extendedFloatingActionButton2.isExtended) {
                extendedFloatingActionButton.extend()
                extendedFloatingActionButton2.extend()
            }

            // if the nestedScrollView is at the first item of the list then the
            // extended floating action should be in extended state
            if (scrollY == 0) {
                extendedFloatingActionButton.extend()
                extendedFloatingActionButton2.extend()
            }

        }


        val data= arrayListOf<Itempost>(
            Itempost("https://s6.uupload.ir/files/mohsenchavoshi_xhhm.jpg",
                "محسن چاوشی","خواننده پاپ",
                "محسن چاوشی پس از دریافت فوق دیپلم حسابداری و اتمام دوره سربازی، فعالیت حرفه\u200Cای خود را در زمینهٔ موسیقی در سال ۱۳۸۲ با آلبوم نفرین آغاز کرد و پس از اخذ مجوز در سال ۱۳۸۷ آلبوم یه شاخه نیلوفر را منتشر کرد. از وی تاکنون بیش از ۲۰۰ قطعه موسیقی شنیده شده\u200Cاست، که شامل ۱۱ آلبوم و نیز چندین تک\u200Cآهنگ است.[۱۰]\n" +
                        "\n" +
                        "وی خواننده و آهنگساز ترانه\u200Cهای فیلم سینمایی سنتوری ساختهٔ داریوش مهرجویی بود. چاوشی همچنین یک قطعه برای تیتراژ پایانی فیلم سینمایی لامپ ۱۰۰ به کارگردانی سعید آقاخانی خواند.\n" +
                        "\n" +
                        "چاوشی خواننده ترانه\u200Cهای سریال شبکه خانگی شهرزاد ساختهٔ حسن فتحی می\u200Cباشد که این ترانه\u200Cها خصوصاً تک\u200Cآهنگ کجایی نقش بسزایی در محبوبیت او داشت.[۱۱][۱۲]",false,""),

            Itempost("https://s6.uupload.ir/files/t1_1637657384512_oy4o.jpg",
                "حامد زمانی","خواننده جدید",
                "در ۱ خرداد ۱۳۹۳، قرار بود حامد زمانی در افتتاحیه هفته فرهنگ رضوی استان کرمان اجرای کنسرت داشته باشد که به علت وقوع تصادف به این همایش نرسید. بعداً اعلام شد زمانی در سلامتی و بهبود کامل از لحاظ جسمی به سر می\u200Cبرد.[۱۱]\n" +
                        "در ۱۲ مرداد ۱۳۹۶ از اجرای کنسرت حامد زمانی در جشن میلاد امام رضا در مشهد ممانعت به عمل آمد.[۱۲][۱۳] پس از آن، سعید سرابی مدیر کل وزارت فرهنگ و ارشاد اسلامی در استان خراسان رضوی اعلام کرد لغو اجرای زنده زمانی هیچ ارتباطی به اداره فرهنگ و ارشاد اسلامی ندارد و هیچ درخواست مجوزی برای اجرای کنسرت این خواننده در ایام میلاد امام رضا ارائه نشد. همچنین سعید سرابی ادعا کرد که ظاهراً مجری برنامه اجازه اجرا را به حامد زمانی نداد.[۱۴] در این\u200Cباره حامد زمانی نیز گفت:\n" +
                        "این اتفاق با وجود همه هماهنگی\u200Cها و تلاش شبانه\u200Cروزی تیم ما برای اجرای این برنامه درخور شأن مردم مشهد و امام رضا اتفاق افتاده\u200Cاست. پس از این تصمیم و ابلاغ آن به ما، بدون عذرخواهی و هیچ توضیحی، راهی تهران شدیم و متأسفانه این رویه در چنین روزی بسیار ناراحت\u200Cکننده بود. ابتدا به\u200Cدلیل محدودیت حضور ساز روی صحنه، طبق قرار اولیه قرار بود با سه کیبورد و لپ\u200Cتاپ روی صحنه برویم. ساعاتی پیش از اجرا از ما خواسته شد فقط با یک کیبورد روی صحنه برویم؛ اما با توجه به تمرین\u200Cها و تنظیم آثار، شرایط جوری بود که اجرا برای ما با یک کیبورد غیرممکن بود. حتی اعضای گروه من به احترام نام امام رضا حاضر بودند، در اتاقک\u200Cهایی که کسی دید نداشت، ساز بزنند تا اجرا برگزار شود، ولی متأسفانه موافقت نشد و همان\u200Cجا بود که من احساس کردم، شیطنت\u200Cهایی برای اجرا نشدن این برنامه وجود دارد. من هیچ لغو کنسرتی را تأیید نمی\u200Cکنم، مخصوصاً موسیقی\u200Cهایی با فرم و محتوای فاخر. ما برای حفظ شأن و حرمت مکانی و زمانی برنامه، یک هفته تمرین کردیم تا بتوانیم با تجهیزات دیجیتال و چند کیبورد، بدون سازهای دیگر گروه\u200Cمان اجرا داشته باشیم، ولی این رفتارها فقط نام مشهد را در کشور خراب می\u200Cکند و بهانه به\u200Cدست معاندان ضدانقلاب خارج از کشور می\u200Cدهد",false,""),

            Itempost("https://s6.uupload.ir/files/zandvaki_qha.jpg",
                "علی زند وکیلی","خواننده سنتی",
                "علی زند وکیلی فعالیت هنری خود را از هفت سالگی با نواختن تنبک و آواز آغاز کرد و در سال ۱۳۷۷ به هنرستان موسیقی شیراز وارد شد و نواختن سنتور و پیانو را آموخت. سال ۱۳۸۱ به هنرستان موسیقی تهران وارد و از همان هنرستان فارغ\u200Cالتحصیل شد. وی به همراه برادر خود، محمد زند وکیلی و میلاد ذبیحی گروهی را تحت عنوان زند بند تأسیس کرد. علاوه بر آن سابقه همکاری با گروه\u200Cهای دنگ شو، خموش، طلوع، نغمه کیمیا، شروند و گلبانگ را دارد و کنسرت\u200Cهایی نیز به همراه این گروه\u200Cها برگزار کرده\u200Cاست.\n" +
                        "از جمله کارهای شاخص وی می\u200Cتوان به تیتراژ مجموعه\u200Cهای دزد و پلیس، پژمان (آخر قصه)، شاهگوش (زهره)، پادری (پادری) زیر پای مادر (آخرین رؤیا)و سریال خانگی اقا زاده (آخرین آواز) اشاره کرد. او در زمستان ۱۳۹۲ آلبومی را تحت عنوان عبور از مه در سبک سنتی با اشعاری از حافظ، زهرا پناهی، حسین منزوی و وحشی بافقی در ۱۴ قطعه منتشر کرد.[نیازمند منبع] علی زندوکیلی در بهمن ۱۳۹۳ در اختتامیه جشنواره فیلم فجر به همراه مهران مدیری آهنگ\u200Cهای ناردونه و رفتی را به صورت زنده اجرا کرد که بسیار از این اجرای او استقبال شد.[۴] علی زندوکیلی در سی\u200Cامین جشنواره موسیقی فجر در شیراز در ۲۴ بهمن ماه ۱۳۹۳ به اجرای برنامه پرداخت.",false,""),
            Itempost("https://s6.uupload.ir/files/mohsenchavoshi_xhhm.jpg",
                "محسن چاوشی","خواننده پاپ",
                "محسن چاوشی پس از دریافت فوق دیپلم حسابداری و اتمام دوره سربازی، فعالیت حرفه\u200Cای خود را در زمینهٔ موسیقی در سال ۱۳۸۲ با آلبوم نفرین آغاز کرد و پس از اخذ مجوز در سال ۱۳۸۷ آلبوم یه شاخه نیلوفر را منتشر کرد. از وی تاکنون بیش از ۲۰۰ قطعه موسیقی شنیده شده\u200Cاست، که شامل ۱۱ آلبوم و نیز چندین تک\u200Cآهنگ است.[۱۰]\n" +
                        "\n" +
                        "وی خواننده و آهنگساز ترانه\u200Cهای فیلم سینمایی سنتوری ساختهٔ داریوش مهرجویی بود. چاوشی همچنین یک قطعه برای تیتراژ پایانی فیلم سینمایی لامپ ۱۰۰ به کارگردانی سعید آقاخانی خواند.\n" +
                        "\n" +
                        "چاوشی خواننده ترانه\u200Cهای سریال شبکه خانگی شهرزاد ساختهٔ حسن فتحی می\u200Cباشد که این ترانه\u200Cها خصوصاً تک\u200Cآهنگ کجایی نقش بسزایی در محبوبیت او داشت.[۱۱][۱۲]",false,""),
            Itempost("https://s6.uupload.ir/files/mohsenchavoshi_xhhm.jpg",
                "محسن چاوشی","خواننده پاپ",
                "محسن چاوشی پس از دریافت فوق دیپلم حسابداری و اتمام دوره سربازی، فعالیت حرفه\u200Cای خود را در زمینهٔ موسیقی در سال ۱۳۸۲ با آلبوم نفرین آغاز کرد و پس از اخذ مجوز در سال ۱۳۸۷ آلبوم یه شاخه نیلوفر را منتشر کرد. از وی تاکنون بیش از ۲۰۰ قطعه موسیقی شنیده شده\u200Cاست، که شامل ۱۱ آلبوم و نیز چندین تک\u200Cآهنگ است.[۱۰]\n" +
                        "\n" +
                        "وی خواننده و آهنگساز ترانه\u200Cهای فیلم سینمایی سنتوری ساختهٔ داریوش مهرجویی بود. چاوشی همچنین یک قطعه برای تیتراژ پایانی فیلم سینمایی لامپ ۱۰۰ به کارگردانی سعید آقاخانی خواند.\n" +
                        "\n" +
                        "چاوشی خواننده ترانه\u200Cهای سریال شبکه خانگی شهرزاد ساختهٔ حسن فتحی می\u200Cباشد که این ترانه\u200Cها خصوصاً تک\u200Cآهنگ کجایی نقش بسزایی در محبوبیت او داشت.[۱۱][۱۲]",false,""),
            Itempost("https://s6.uupload.ir/files/mohsenchavoshi_xhhm.jpg",
                "محسن چاوشی","خواننده پاپ",
                "محسن چاوشی پس از دریافت فوق دیپلم حسابداری و اتمام دوره سربازی، فعالیت حرفه\u200Cای خود را در زمینهٔ موسیقی در سال ۱۳۸۲ با آلبوم نفرین آغاز کرد و پس از اخذ مجوز در سال ۱۳۸۷ آلبوم یه شاخه نیلوفر را منتشر کرد. از وی تاکنون بیش از ۲۰۰ قطعه موسیقی شنیده شده\u200Cاست، که شامل ۱۱ آلبوم و نیز چندین تک\u200Cآهنگ است.[۱۰]\n" +
                        "\n" +
                        "وی خواننده و آهنگساز ترانه\u200Cهای فیلم سینمایی سنتوری ساختهٔ داریوش مهرجویی بود. چاوشی همچنین یک قطعه برای تیتراژ پایانی فیلم سینمایی لامپ ۱۰۰ به کارگردانی سعید آقاخانی خواند.\n" +
                        "\n" +
                        "چاوشی خواننده ترانه\u200Cهای سریال شبکه خانگی شهرزاد ساختهٔ حسن فتحی می\u200Cباشد که این ترانه\u200Cها خصوصاً تک\u200Cآهنگ کجایی نقش بسزایی در محبوبیت او داشت.[۱۱][۱۲]",false,""),
            Itempost("https://s6.uupload.ir/files/mohsenchavoshi_xhhm.jpg",
                "محسن چاوشی","خواننده پاپ",
                "محسن چاوشی پس از دریافت فوق دیپلم حسابداری و اتمام دوره سربازی، فعالیت حرفه\u200Cای خود را در زمینهٔ موسیقی در سال ۱۳۸۲ با آلبوم نفرین آغاز کرد و پس از اخذ مجوز در سال ۱۳۸۷ آلبوم یه شاخه نیلوفر را منتشر کرد. از وی تاکنون بیش از ۲۰۰ قطعه موسیقی شنیده شده\u200Cاست، که شامل ۱۱ آلبوم و نیز چندین تک\u200Cآهنگ است.[۱۰]\n" +
                        "\n" +
                        "وی خواننده و آهنگساز ترانه\u200Cهای فیلم سینمایی سنتوری ساختهٔ داریوش مهرجویی بود. چاوشی همچنین یک قطعه برای تیتراژ پایانی فیلم سینمایی لامپ ۱۰۰ به کارگردانی سعید آقاخانی خواند.\n" +
                        "\n" +
                        "چاوشی خواننده ترانه\u200Cهای سریال شبکه خانگی شهرزاد ساختهٔ حسن فتحی می\u200Cباشد که این ترانه\u200Cها خصوصاً تک\u200Cآهنگ کجایی نقش بسزایی در محبوبیت او داشت.[۱۱][۱۲]",false,""),
            Itempost("https://s6.uupload.ir/files/mohsenchavoshi_xhhm.jpg",
                "محسن چاوشی","خواننده پاپ",
                "محسن چاوشی پس از دریافت فوق دیپلم حسابداری و اتمام دوره سربازی، فعالیت حرفه\u200Cای خود را در زمینهٔ موسیقی در سال ۱۳۸۲ با آلبوم نفرین آغاز کرد و پس از اخذ مجوز در سال ۱۳۸۷ آلبوم یه شاخه نیلوفر را منتشر کرد. از وی تاکنون بیش از ۲۰۰ قطعه موسیقی شنیده شده\u200Cاست، که شامل ۱۱ آلبوم و نیز چندین تک\u200Cآهنگ است.[۱۰]\n" +
                        "\n" +
                        "وی خواننده و آهنگساز ترانه\u200Cهای فیلم سینمایی سنتوری ساختهٔ داریوش مهرجویی بود. چاوشی همچنین یک قطعه برای تیتراژ پایانی فیلم سینمایی لامپ ۱۰۰ به کارگردانی سعید آقاخانی خواند.\n" +
                        "\n" +
                        "چاوشی خواننده ترانه\u200Cهای سریال شبکه خانگی شهرزاد ساختهٔ حسن فتحی می\u200Cباشد که این ترانه\u200Cها خصوصاً تک\u200Cآهنگ کجایی نقش بسزایی در محبوبیت او داشت.[۱۱][۱۲]",false,""),



        )
        val myadapter= porbazdidadaptor(data,this)


        binding.rcyclePorbazdid.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.rcyclePorbazdid.adapter=myadapter





        val fraginja=Fragporbazdid()

        binding.extFabPortrafdar.setOnClickListener {



            val asli = Fragtrend(this)
            asli.show(requireActivity().supportFragmentManager, null)

        }
        binding.ext2FabPortrafdar.setOnClickListener {


            Toast.makeText(context, "به زودی", Toast.LENGTH_SHORT).show()

        }




}

    override fun onitemclicked(itempost: Itempost) {
        val intent=Intent(activity,MainActivity2::class.java)
        intent.putExtra(SENDING_DATA_WITH_INTENTTOMAINACTIVITY_INORDERTOSHOWOURCONTENT,itempost)
        startActivity(intent)
    }
}