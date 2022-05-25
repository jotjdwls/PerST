package com.example.perst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.perst.R;

public class WhiteNoise extends Fragment {
    Button rBtn, playBtn, pauseBtn;
    TextView hstTv, dateTv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_noise, container, false);

        final MediaPlayer musicPlayer;
        musicPlayer = MediaPlayer.create(getContext(), R.raw.rainysound);

        rBtn = (Button) view.findViewById(R.id.randomButton);
        playBtn = (Button) view.findViewById(R.id.playButton);
        pauseBtn = (Button) view.findViewById(R.id.pauseButton);
        dateTv = (TextView) view.findViewById(R.id.Date_and_Time);
        hstTv = (TextView) view.findViewById(R.id.helpStudyText);

        final String[] array = {
                "꾸준한 노력이 함께하지 않는 꿈은\n몽상에 불과하다.\n꿈에는 지름길이 없다.\n\n- 이나므리 가즈오 -",
                "반복에 지치지 않는 자가\n성공한다.\n\n- 만화 <미생> -",
                "너는 남들보다 한참 늦었는데\n어찌 남들과 같은 속도로\n가려 하느냐.\n\n- 에이브라함 마즐로 -",
                "당신의 삶을 오늘 바꾸어라.\n미래에 걸지 말아라.\n미루지 말고 지금 행동하라.\n\n- 시몬드 보부아르 -",
                "\'언젠가\'는 위험한 단어에요.\n절대 못하게 되는 경우가\n많거든요.\n\n- 영화 <knight and day> -",
                "공부벌레들에게 잘 해주십시오.\n나중에 그 사람 밑에서\n일하게 될 수도 있습니다.\n\n- 빌 게이츠 -",
                "많이 보고 많이 겪고\n많이 공부하는 것은\n배움의 세 기둥이다.\n\n- 벤자민 디즈라엘리 -",
                "꿈을 크게 가져라.\n깨져도 조각이 크다.\n\n- 글귀 -",
                "행동을 미루는 것은\n신용카드와 마찬가지이다.\n즐거움을 만끽할 수 있지만,\n그것은 늘 빚 갚을때가\n돌아오기 전까지일 뿐이다.\n\n-크리스토퍼 파커-",
                "우리가\n노력없이 얻을 수 있는 유일한 것은\n노년뿐이다.\n\n- 글로리아 피쳐 -",
                "고통이 남기고 간 뒤를 보라.\n고난이 지나면\n반드시 기쁨이 스며든다.\n\n- 괴테 -",
                "마음만을 가지고 있어서는 안된다.\n반드시 실천하여야 한다.\n\n- 이소룡 -",
                "성공은\n열심히 노력하며\n기다리는 사람에게\n찾아온다.\n\n- 토마스 에디슨-",
                "도전에 성공하지 않는 비결은\n단 하나,\n결단코 포기하지 않는 일이다.\n\n- 디오도어 루빈 -",
                "포기하고 주저앉으면\n주저앉는 그 자리가\n영원한 당신의 자리가 된다는 것을\n명심하라.\n\n- 조수미 -",
                "무슨 일이든 할 수 있다고\n생각하는 사람이\n결국 해내는 법이다.\n\n- 정주영 -",
                "오늘 인생을 바꿔라\n미래를 걸고 행운만 믿지 말고\n지금 당장\n지체 없이 행동하라.\n\n- 시몬 드 보부아르 -",
                "할 수 있다는 믿음을 가지면\n그런 능력이 없을지라도\n결국에는 할 수 있는 능력을\n갖게 된다.\n\n- 마하트마 간디 -",
                "실패하는 사람들의 90%는\n정말로 패배하는 것이 아니라\n포기하는 것이다.\n\n- 폴.J.마이어 -",
                "공부는 하지만\n생각을 하지 않으면\n길을 잃은 사람이고\n생각은 하지만\n공부를 하지 않으면\n위험한 사람이다.\n\n- 공자 -",
                "태도의 차이는 아주 사소하지만\n결과의 차이는\n아주 거대하다.\n\n- 윈스턴 처칠 -",
                "성공은\n보통 너무 바빠서\n찾기 힘든 사람들에게\n옵니다.\n\n- 헨리 데이비드 소로 -",
                "열심히 공부하는 것을\n두려워하지 마십시오.\n지식은 결코\n마음을 지치게 하지 않습니다.\n\n- 바노비츠 -",
                "행동의 가치는\n그 행동을\n끝까지 이루는 데 있다.\n\n- 칭기스칸 -",
                "내일은 어제로부터\n무엇인가 배웠기를\n바란다.\n\n- 존 웨인 -",
                "재능이 없다고 말하는\n사람들은\n대부분 별로 시도해본 일이\n없는 사람들이다.\n\n- 앤드류 매튜스 -",
                "교육의 위대한 목표는\n앎이 아니라\n행동이다.\n\n- 허버트 스펜서 -",
                "이도 저도 할 수 없다고\n생각하는 한,\n그것을 하지 않기로\n마음먹는 한,\n결과적으로 그것을 하기란\n 불가능해진다.\n\n- 바뤼흐 스피노자 -",
                "교육 없는 천재는\n광산 속의 은이나\n마찬가지이다.\n\n- 벤자민 프랭클린 -",
                "대부분의 사람들은\n자신이 마음먹은 만큼만\n행복하다.\n\n- 아브라함 링컨 -"
        };

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREAN);
        dateTv.setText(df.format(date));

        Random random = new Random();
        Integer randNum[] = new Integer[array.length];

        rBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for (int i = 0; i < array.length; i++) {
                    randNum[i] = random.nextInt(array.length);
                    hstTv.setText(array[randNum[i]]);
                }
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(musicPlayer.isPlaying()){ //음악이 실행되고 있으면

                }
                musicPlayer.setLooping(true);
                musicPlayer.start();
                playBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.VISIBLE);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicPlayer.pause();
                playBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.GONE);
            }
        });

        return view;

    }
}