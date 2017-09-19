package hike.me.webify.getyourhikeon;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoFragment extends android.support.v4.app.Fragment {
    private View view;
    private Context context;
    private FirebaseAuth firebaseAuth;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

//        firebaseAuth = FirebaseAuth.getInstance();


        view = inflater.inflate(R.layout.fragment_info, container, false);
        context = view.getContext();
        expListView = (ExpandableListView) view.findViewById(R.id.info);

//        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                Toast.makeText(
//                        context,
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
//                return false;
//            }
//        });
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(context, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        return view;
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("About Us");
        listDataHeader.add("Terms and conditions");
        listDataHeader.add("Privacy Policay");

        // Adding child data
        List<String> aboutus = new ArrayList<String>();
        aboutus.add("1.Common Sense - well, not in my fanny, but with me at all times. :-)   Good judgment saves more people than any equipment. Poor judgment kills. If dark clouds are approaching, go home. If your heel feels hot, stop hiking. Obey signs and guidelines and think about what you are going to do before you do it.The word \"touron\" is used by National Park employees - it is a combination of \"tourist\" and \"moron\" - don\\'t be one.\n" +
                "This includes having your trek plan and leaving a copy of it with a friend at home.\n" +
                "\\n\\n2.Pack - I get all my stuff into a fanny pack, except for my water. You may choose a bigger pack instead, but make sure it is good quality and comfortable.\n" +
                "\\n\\n3.Map and Compass - Whether you\\'ve been on this trail 50 times or this is your first, there is always a chance of getting lost. Unexpected injuries, bad weather, a closed trail, wild animals may all require an immediate change in route.A compass is not like an insurance policy - just having it does you no good. You have to know how to use it properly along with reading your map correctly so you can stay on course or get back on course. Having just a compass or just a map is not good enough; treat them as a single team.\n" +
                "\\n\\n4.Water - One quart of water weighs 2 pounds. That\\'s why so many people don\\'t bring enough water on hikes. But, you need at least 3 quarts per day. It\\'s a good idea to drink plenty of water before your hike to get your body well hydrated.Many people carry Nalgene bottles - practically indestructible plastic bottles in any color you can imagine. A hydration system that carries water on your back, such as Camelbak, is a popular, flexible way to take water along. I prefer carrying two bota bags because I can carry them many different ways and they are still flexible and inexpensive.If you know there is a potable water source on your route, you can plan a refill there. Or, take along a lightweight water filter to collect water from a lake or stream.\n" +
                "\\n\\n5.Flashlight - Even if you start hiking at 6:00am and will be finished by 11:00am, still take your flashlight. An injury or bad weather can easily keep you out through the night. LED headlamps are very bright, very small, inexpensive, and last a long time.\n" +
                "\\n\\n6.Food - Your body will expend lots of energy hauling you all over the hills. Continually snacking throughout the hike is a good way to keep the tank full and the motor running. If you wait to drink when you feel thirsty and wait to eat when you feel hungry, your body will already be in need. It\\'s better to drink and eat a bit often throughout the day to stay strong.High energy, compact foods are good choices because they take up little space. You should carry at least 2000 calories of food. See my hiking food page for more information.\n" +
                "\\n\\n7.Raingear and Clothes - A $5.00 plastic poncho is fine for quick protection from a passing thunderstorm. If you are a summer hiker at low elevations, then that\\'s probably all you need for raingeer. But, I hike in the mountains and rain can feel more like ice up there and the implications of not being prepared can be deadly. I always take a good raincoat with hood and rain pants. I can wear the extra layer to stay warm when the temperature drops, to stay dry in fog and dampness, and to shed rain or snow. The pants are critical and often overlooked.Extra clothes need to be kept dry so you should put them in a big ziploc. Include at least a hat, pair of socks, polypropylene long underpants and undershirt. Avoid cotton clothes. See the hiking clothes page for details on clothes to wear and take.\n" +
                "\\n\\n8.Firestarter and Matches - I always have matches in film cannister, cigarette lighter, and magnesium sparker. That\\'s three ways I can get warmth if I get caught in a bad situation. The magnesium lighter weighs quite a bit, but it is my final backup that works when wet.You might want to take waterproof matches, but cheap ones are not really waterproof and expensive ones are really expensive. Plus, they tend to get used for non-emergency tasks like lighting a campfire.\n" +
                "\\n\\n9.First Aid Kit - a small kit with basic supplies like moleskin, tweezers, bandaids, antiseptic wipes, gauze pad, and tape is adequate for most problems.\n" +
                "\\n\\n10.Knife - I love my knife. I usually have a stick on backpacking treks that I spend time carving on breaks and around camp. Make sure your knife is sharpened before you leave home. A pocketknife with a 3 inch blade is fine - no need for a big Bowie knife.\n" +
                "\\n\\n11.Sunglasses and Sunscreen - Bright sun is very hard on your eyes. The squinting can give you headaches too. Wearing good sunglasses will make the day much more pleasant and safe. Glacier glasses are my favorite because they have removable side screens and curl around my ears so they stay on - plus, they look way cool.Long sleeve shirt and a wide-brim hat really should be worn when you are hiking all day. Add sunscreen to your exposed parts and your skin will thank you. Use a sunscreen that has no perfume so you don\\'t attract bugs and critters.\n" +
                "\\n\\n12.Whistle - All you need to do is blow air. Even if both your legs are broken and you are at the bottom of a cliff, you can still use it and the sound of a whistle can carry far to rescuers. Only use it for emergencies, not just for the fun of it while hiking.\n" +
                "\\n\\n13.Insect Protection - DEET is your friend. Latest research from the EPA has shown that DEET is safe for all family members to use. DEET really works, too. I\\'ve tried lots of different kinds of repellents in Minnesota/Wisconsin where there are plenty of mosquitos, ticks, and other critters. I\\'ve found that mixing one ounce of 100% DEET into a 6 oz. pump bottle of 6% or 7% DEET repellent creates a 20% DEET mixture that keeps everything away. I use this on week-long backpacking trips too.I also have an insect repellent shirt and pants. I don\\'t think they really work, at least not for the aggressive bugs I encounter. But, just having long sleeves and long pants protects much more of your body so the problem is reduced. Wearing very light long shirt and pants is actually a good thing and not too hot for most hiking.\n" +
                "\\n\\n14.Key and License - I leave all my pocket junk locked in my car except for my identification and key. Makes things lighter and I won\\'t be charging it out where I\\'m headed.\n" +
                "\\n\\n15.Change - you\\'ll see in the photo that #15 is a few quarters. That was for payphones at trailheads, but you can\\'t find them any longer. Just ask anyone around with a cellphone if you don\\'t have one.\n" +
                "\\n\\n16.Nylon cord - There are too many uses to list for a piece of thin cord, from making a new shoelace to an emergency shelter. It\\'s just a good piece of insurance.\n" +
                "\\n\\n17.Trash Bag - Roll up a heavy-duty lawn bag for emergencies. There are lots of potential uses and it takes little space.\n" +
                "\\n\\n18.Toilet Paper - Kept dry in a zip-log bag. Keep another zip-log bag for packing out the used paper.");

        List<String> terms = new ArrayList<String>();
        terms.add("The Conjuring");

        List<String> privacy = new ArrayList<String>();
        privacy.add("2 Guns");

        listDataChild.put(listDataHeader.get(0), aboutus); // Header, Child data
        listDataChild.put(listDataHeader.get(1), terms);
        listDataChild.put(listDataHeader.get(2), privacy);
    }

}
