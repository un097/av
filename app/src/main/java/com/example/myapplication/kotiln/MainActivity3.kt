//package com.example.myapplication.kotiln
//
//
//import android.content.Context
//import android.content.Intent
//import android.hardware.*
//import android.os.Bundle
//import android.view.Surface
//import androidx.activity.ComponentActivity
//
//import androidx.core.content.ContextCompat.startActivity
//import kotlinx.coroutines.launch
//
//
//class MainActivity3 : ComponentActivity(), SensorEventListener{
//
//
//    private lateinit var sensorManager: SensorManager
//    private var mSensor: Sensor? = null
//    private val NS2S = 1.0f / 1000000000.0f
//    private val timestamp = 0f
//
//
//    @ExperimentalAnimationApi
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        var xDistance by remember { mutableStateOf(0f) }
//        var yDistance by remember { mutableStateOf(0f) }
//        setContent {
//            MyApplicationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
////                    Banner(x = xDistance, Y = yDistance)
//                    HomeScreen()
//                }
//            }
//        }
//
////        val context = LocalContext.current
//        val sensorManager = getSystemService(Context.SENSOR_SERVICE)  as SensorManager
////        mLight = sensorManager.getDefaultSensor((Sensor.TYPE_LIGHT))
//        val sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
//
//    }
//
//    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onSensorChanged(event: SensorEvent?) {
//        if (timestamp != 0) {
//            final float dT = (event.timestamp - timestamp) * NS2S;
//            // Axis of the rotation sample, not normalized yet.
//            float axisX = event?.values?.get[0]!!
//            float axisY = event?.values?.get[1]!!
//            float axisZ = event?.values?.get[2]!!
//
//            // Calculate the angular speed of the sample
//            float omegaMagnitude = sqrt(axisX*axisX + axisY*axisY + axisZ*axisZ);
//
//            // Normalize the rotation vector if it's big enough to get the axis
//            if (omegaMagnitude > EPSILON) {
//                axisX /= omegaMagnitude;
//                axisY /= omegaMagnitude;
//                axisZ /= omegaMagnitude;
//            }
//
//            // Integrate around this axis with the angular speed by the time step
//            // in order to get a delta rotation from this sample over the time step
//            // We will convert this axis-angle representation of the delta rotation
//            // into a quaternion before turning it into the rotation matrix.
//            float thetaOverTwo = omegaMagnitude * dT / 2.0f;
//            float sinThetaOverTwo = sin(thetaOverTwo);
//            float cosThetaOverTwo = cos(thetaOverTwo);
//            deltaRotationVector[0] = sinThetaOverTwo * axisX;
//            deltaRotationVector[1] = sinThetaOverTwo * axisY;
//            deltaRotationVector[2] = sinThetaOverTwo * axisZ;
//            deltaRotationVector[3] = cosThetaOverTwo;
//        }
//        timestamp = event.timestamp;
//        float[] deltaRotationMatrix = new float[9];
//        SensorManager.getRotationMatrixFromVector(deltaRotationMatrix, deltaRotationVector);
//
//
//
//
//
//
//        //   上秤，78KG---“哦， 秤坏了”
////       体检，77KG，超重---“md测的真准”
////       夜跑一个月，79kg--哎呀
//        //
//
////
////        var speedY =event?.values?.get(1)!!
////        var speedX =event?.values?.get(0)!!
////        var speedZ =event?.values?.get(2)!!
////        // 将手机在各个轴上的旋转角度相加
////        var angularX = (event.values[0] * dT).toLong()
////        var angularY = (event.values[1] * dT).toLong()
////        var angularZ = (event.values[2] * dT).toLong()
////
////        //设置x轴y轴最大边界值，
////        if (angularY > mMaxAnular) {
////            angularY = mMaxAnular.toFloat()
////        } else if (angularY < -mMaxAnular) {
////            angularY = -mMaxAnular.toFloat()
////        }
////
////        if (angularX > mMaxAnular) {
////            angularX = mMaxAnular.toFloat()
////        } else if (angularX < -mMaxAnular) {
////            angularX = -mMaxAnular.toFloat()
////        }
////
////        val xRadio: Float = (angularY / mMaxAnular).toFloat()
////        val yRadio: Float = (angularX / mMaxAnular).toFloat()
////        xDistance = xRadio * maxOffset
////        yDistance = yRadio * maxOffset
//
//    }
//
//
//
//}
//
////
////fun Image(
////    painter: Painter, // 要绘制的图片(还可以是ImageVector和ImageBitmap)
////    contentDescription: String?, // 用来描述图片，等价于ImageView的contentDescription
////    modifier: Modifier = Modifier, // 修饰符
////    alignment: Alignment = Alignment.Center, // 对齐方式，等价于ImageView的gravity，默认居中显示
////    contentScale: ContentScale = ContentScale.Fit, // 缩放方式，等价于ImageView的scaleType，默认是ContentScale.Fit，等价于ImageView的fitCenter
////    alpha: Float = DefaultAlpha, // 透明度，等价于ImageViwe的alpha，默认为1.0
////    colorFilter: ColorFilter? = null // 颜色过滤器，可以对图片色值进行混合处理
////)
//
//
//@Composable
//fun Chip(modifier: Modifier = Modifier, text: String) {
//    Card(
//            modifier = modifier,
//            border = BorderStroke(color = Color.Black, width = Dp.Hairline),
//            shape = RoundedCornerShape(8.dp)
//    ) {
//        Row(
//                modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
//                verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                    modifier = Modifier
//                            .size(16.dp, 16.dp)
//                            .background(color = MaterialTheme.colors.secondary)
//            )
//            Spacer(Modifier.width(4.dp))
//            Text(text = text)
//        }
//    }
//}
//
//@ExperimentalAnimationApi
//@Composable
//fun ArtistCard() {
//    var screen by  remember { mutableStateOf("home") }
//    if (screen == "home") {
//        Column(
//                Modifier
//                        .padding(16.dp)
//                        .clickable { }
//                        .offset(y = 3.dp)
////    clickable 使可组合项响应用户输入，并显示涟漪。
////    padding 在元素周围留出空间。
////    fillMaxWidth 使可组合项填充其父项为它提供的最大宽度。
////    size() 指定元素的首选宽度和高度
//        ) {
//            Box() {
//                Card() {
//                    var expanded by remember { mutableStateOf(false) }
//                    Column(Modifier.clickable { expanded = !expanded }) {
//                        Image(
//                                painter = painterResource(id = R.drawable.yan2),
//                                contentDescription = "顶部背景图"
//                        )
//                        AnimatedVisibility(visible = expanded) {
//                            Text(
//                                    text = "Jetpack",
//                                    style = MaterialTheme.typography.h2
//                            )
//
//                        }
//                    }
//                }
//                Row(
////            size()确定 长宽
//                        Modifier.fillMaxWidth(),
////            Row 中设置子项的位置，请设置 horizontalArrangement
////            和 verticalAlignment 参数
////            verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceAround,
//                ) {
//
//                    Chip(
//                            Modifier
//                                    .paddingFromBaseline(85.dp)
//                                    .offset(x = 12.dp)
//                                    .clickable { screen = "ganme" },
//                            "游戏",
//                    )
//                    Text(text = "阴阳", Modifier.paddingFromBaseline(30.dp))
//                    Text(text = "八卦", Modifier.paddingFromBaseline(95.dp))
//
//                    Chip(
//                            Modifier
//                                    .paddingFromBaseline(15.dp)
//                                    .clickable { screen = "tianqi" },
//                            "天气",
//                    )
//
//
//                    Text(text = "地图", Modifier.paddingFromBaseline(75.dp))
//                    Text(text = "舞蹈", Modifier.paddingFromBaseline(40.dp))
//                    Text(text = "人文", Modifier.paddingFromBaseline(78.dp))
//                }
//
//            }
//            Spacer(Modifier.height(20.dp))
//            Text("今天又是美好的一天")
//            Spacer(Modifier.height(10.dp))
//            Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End,
//                    verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = "是的呢")
//                Image(
//                        painter = painterResource(R.drawable.face),
//                        contentDescription = null,
//                        Modifier.size(48.dp, 48.dp)
//                )
//            }
//            Spacer(Modifier.height(10.dp))
//            Text("接下来干什么")
//            Spacer(Modifier.height(10.dp))
//
//            Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End,
//                    verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text("远赴人间惊鸿宴")
//                Image(
//                        painter = painterResource(R.drawable.face),
//                        contentDescription = null,
//                        Modifier.size(48.dp, 48.dp)
//                )
//            }
//            Spacer(Modifier.height(10.dp))
//
//            Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End,
//                    verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text("一睹人间盛世颜")
//                Image(
//                        painter = painterResource(R.drawable.face),
//                        contentDescription = null,
//                        Modifier.size(48.dp, 48.dp)
//                )
//            }
//
//            Spacer(Modifier.height(10.dp))
//
//            Chip(text = "说点什么呢...")
//        }
//    }
//    when (screen){
//        "tianqi" -> {
//            Text(text = "123",Modifier.clickable { screen="home" })
////            Banner()
//        }
//        "game"  -> game()
//
//
//    }
//
//
//
//
//}
//
//@ExperimentalAnimationApi
//@Composable
//fun HomeScreen() {
//
//    val scaffoldState = rememberScaffoldState()
//    val scope = rememberCoroutineScope()
//    Scaffold(
//            scaffoldState = scaffoldState,
//            drawerContent = {
//                Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "抽屉组件中内容")
//                }
//            },
//
//            //标题栏区域
//            topBar = {
//                TopAppBar(
//                        title = { Text(text = "某天某月某日") },
//                        navigationIcon = {
//                            IconButton(
//                                    onClick = {
//                                        scope.launch { scaffoldState.drawerState.open() }
//                                    }
//                            ) {
//                                Icon(
//                                        imageVector = Icons.Filled.Menu,
//                                        contentDescription = null
//                                )
//                            }
//                        },
//                        actions = { IconButton(onClick = { /* doSomething() */ }) {
//                            Icon(Icons.Filled.Settings, contentDescription = null)
//                        }
//                        }
//
//                )
//            },
//
//            //悬浮按钮
//            floatingActionButton = {
//                Row(
//                        Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceAround,
//                ) {
//                    ExtendedFloatingActionButton(
//                            text = { Text("悬浮按钮") },
//                            onClick = { }
//                    )
//                    ExtendedFloatingActionButton(
//                            text = { Text("主页") },
//                            onClick = { }
//                    )
//                    ExtendedFloatingActionButton(
//                            text = { Text("我的") },
//                            onClick = { }
//                    )
//                }
//
//            },
//            floatingActionButtonPosition = FabPosition.Center,
//            //屏幕内容区域
//            content= {
//                ArtistCard()
////            var screen by  remember { mutableStateOf("home") }
////            Text(text = "123",Modifier.clickable { screen="tianqi" })
////            Crossfade(targetState = screen) {
////                when(screen){
////                    "home" ->  ArtistCard()
////                    "tianqi"-> Text(text = "123")
////                }
////            }
//
//            },
//    )
//}
//
//
//@ExperimentalAnimationApi
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//
//    HomeScreen()
//
//}
//
