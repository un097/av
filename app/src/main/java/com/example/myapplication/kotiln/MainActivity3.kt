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
//        //   ?????????78KG---????????? ????????????
////       ?????????77KG?????????---???md???????????????
////       ??????????????????79kg--??????
//        //
//
////
////        var speedY =event?.values?.get(1)!!
////        var speedX =event?.values?.get(0)!!
////        var speedZ =event?.values?.get(2)!!
////        // ?????????????????????????????????????????????
////        var angularX = (event.values[0] * dT).toLong()
////        var angularY = (event.values[1] * dT).toLong()
////        var angularZ = (event.values[2] * dT).toLong()
////
////        //??????x???y?????????????????????
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
////    painter: Painter, // ??????????????????(????????????ImageVector???ImageBitmap)
////    contentDescription: String?, // ??????????????????????????????ImageView???contentDescription
////    modifier: Modifier = Modifier, // ?????????
////    alignment: Alignment = Alignment.Center, // ????????????????????????ImageView???gravity?????????????????????
////    contentScale: ContentScale = ContentScale.Fit, // ????????????????????????ImageView???scaleType????????????ContentScale.Fit????????????ImageView???fitCenter
////    alpha: Float = DefaultAlpha, // ?????????????????????ImageViwe???alpha????????????1.0
////    colorFilter: ColorFilter? = null // ?????????????????????????????????????????????????????????
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
////    clickable ??????????????????????????????????????????????????????
////    padding ??????????????????????????????
////    fillMaxWidth ????????????????????????????????????????????????????????????
////    size() ????????????????????????????????????
//        ) {
//            Box() {
//                Card() {
//                    var expanded by remember { mutableStateOf(false) }
//                    Column(Modifier.clickable { expanded = !expanded }) {
//                        Image(
//                                painter = painterResource(id = R.drawable.yan2),
//                                contentDescription = "???????????????"
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
////            size()?????? ??????
//                        Modifier.fillMaxWidth(),
////            Row ???????????????????????????????????? horizontalArrangement
////            ??? verticalAlignment ??????
////            verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceAround,
//                ) {
//
//                    Chip(
//                            Modifier
//                                    .paddingFromBaseline(85.dp)
//                                    .offset(x = 12.dp)
//                                    .clickable { screen = "ganme" },
//                            "??????",
//                    )
//                    Text(text = "??????", Modifier.paddingFromBaseline(30.dp))
//                    Text(text = "??????", Modifier.paddingFromBaseline(95.dp))
//
//                    Chip(
//                            Modifier
//                                    .paddingFromBaseline(15.dp)
//                                    .clickable { screen = "tianqi" },
//                            "??????",
//                    )
//
//
//                    Text(text = "??????", Modifier.paddingFromBaseline(75.dp))
//                    Text(text = "??????", Modifier.paddingFromBaseline(40.dp))
//                    Text(text = "??????", Modifier.paddingFromBaseline(78.dp))
//                }
//
//            }
//            Spacer(Modifier.height(20.dp))
//            Text("???????????????????????????")
//            Spacer(Modifier.height(10.dp))
//            Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End,
//                    verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = "?????????")
//                Image(
//                        painter = painterResource(R.drawable.face),
//                        contentDescription = null,
//                        Modifier.size(48.dp, 48.dp)
//                )
//            }
//            Spacer(Modifier.height(10.dp))
//            Text("??????????????????")
//            Spacer(Modifier.height(10.dp))
//
//            Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End,
//                    verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text("?????????????????????")
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
//                Text("?????????????????????")
//                Image(
//                        painter = painterResource(R.drawable.face),
//                        contentDescription = null,
//                        Modifier.size(48.dp, 48.dp)
//                )
//            }
//
//            Spacer(Modifier.height(10.dp))
//
//            Chip(text = "???????????????...")
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
//                    Text(text = "?????????????????????")
//                }
//            },
//
//            //???????????????
//            topBar = {
//                TopAppBar(
//                        title = { Text(text = "??????????????????") },
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
//            //????????????
//            floatingActionButton = {
//                Row(
//                        Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceAround,
//                ) {
//                    ExtendedFloatingActionButton(
//                            text = { Text("????????????") },
//                            onClick = { }
//                    )
//                    ExtendedFloatingActionButton(
//                            text = { Text("??????") },
//                            onClick = { }
//                    )
//                    ExtendedFloatingActionButton(
//                            text = { Text("??????") },
//                            onClick = { }
//                    )
//                }
//
//            },
//            floatingActionButtonPosition = FabPosition.Center,
//            //??????????????????
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
