package com.yorick.sharednotes.data.local

import com.yorick.sharednotes.data.model.Note

object LocalNotesDataProvider {
    val allNotes = listOf(
        Note(
            id = 0L,
            author = LocalAccountsDataProvider.getContactAccountById(1L),
            subject = "Shared Notes",
            body = """
                # SharedNotes
                
                ***
                
                A note-taking appliction that supports real-time sharing, Markdown syntax, and supports Android platform and Desktop platform (Windows, MacOS, Linux).
                
                - ๐งโ๐ป Support ๐ฑAndroid and ๐ปDesktop Platform 
                - ๐ Responsive layouts
                - ๐ Support Markdown syntax
                - ๐ช Material Design 3
                - ๐ Dynamic color
                
                ## Essay
                
                Hi guys! I am very happy to participate in the Kotlin Multiplatform contest. My English is not very good, there can be grammatical errors or fuzzy phrases in this essay, pardon me.
                
                ### My Background
                
                I am a junior from Nanjing, China, majoring in software engineering. I love new technology like kotlin and that's why I found it and participated in this competition. New technology is very cool. Absolutely android development is my favorite.
                
                ### Project Background
                
                In our class, many students have the habit of taking class notes. 
                
                But when we wanted to share our notes with other classmates in real time, trouble came. We can't sit together every time, and sometimes we must take online classes because of the COVID-19. It's also not convenient to communicate using chat software like WeChat. For example, to show Markdown. So, I developed Shared Notes, which is a note-taking appliction that supports real-time sharing, Markdown syntax, and supports Android platform and Desktop platform (Windows, MacOS, Linux). Limited to my hardware device, there is no iOS version now, but it is planned.
                
                Depending on time and current personal skills, I have only developed clients for Android and Desktop, which share the full data layer and 75% of the UI layer code. Both Android and desktop platforms support responsive layouts to accommodate devices of different sizes.
                
                Limited to time and personal current state of technology, I only developed Android and Desktop clients, which fully share the data layer and share 75% of the interface layer code. Whether it's Android or desktop, they all support responsive layouts to suit devices of different sizes.
                
                ### Brief introduction
                
                The program consists of five modules: edition, notes, contacts, categories, and tags. Edition involves editing and sharing your notes, supporting  Markdown syntax and dual-screen preview. Notes display notes there are shared by contacts in real time. Contacts may provide the function of viewing and managing contacts (not implemented). And the feature of viewing and managing note categories and tags (not implemented) is supplied by Categories and Tags.
                
                # LICENSE
                
                ```
                MIT License
                
                Copyright (c) 2023 Ruiyu
                
                Permission is hereby granted, free of charge, to any person obtaining a copy
                of this software and associated documentation files (the "Software"), to deal
                in the Software without restriction, including without limitation the rights
                to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
                copies of the Software, and to permit persons to whom the Software is
                furnished to do so, subject to the following conditions:
                
                The above copyright notice and this permission notice shall be included in all
                copies or substantial portions of the Software.
                
                THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
                IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
                FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
                AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
                LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
                OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
                SOFTWARE.
                ```
                """.replace("^", "$").trimIndent(),
            category = LocalCategoriesDataProvider.getCategoryById(3L),
            tag = listOf(1L, 2L, 3L).map { LocalTagsDataProvider.getTagById(it) },
            isStarred = true,
            createdAt = "10 mins ago"
        ),
        Note(
            id = 1L,
            author = LocalAccountsDataProvider.getContactAccountById(8L),
            subject = "Composeๅธๅฑ่ฏฆ่งฃ",
            body = """
            # ๆทฑๅฅไบ่งฃ Jetpack Compose ๅธๅฑ

            Jetpack Compose ๆไพไธไธชๅจๆฐ็ๅธๅฑๆจกๅ๏ผ็จไบๆๅปบ็ฒพ็พใ้ซๆ็็้ขใๆไปฌๆทฑๅฅไป็ปไบ่ฟไธชๅธๅฑๆจกๅ๏ผ่ฏดๆไบๅฎ็ๅบๅฑๅทฅไฝ้ป่พ๏ผๅฎๆๅทๅค็ๅ่ฝ๏ผๆ็ป็ๅธๅฑๅไฟฎ้ฅฐ็ฌฆๆฏๅฆไฝๆๅปบ็๏ผไปฅๅๅฏไปฅๅฆไฝ่ฝปๆพๅๅปบ่ชๅฎไนๅธๅฑๅไฟฎ้ฅฐ็ฌฆใๆฌๆฌก็?่ฎจไผๅฐๆๅฉไบไบ่งฃ Compose ็ๅธๅฑๆจกๅ๏ผๆจๅฏไปฅไฝฟ็จ่ฟไธชๆจกๅๆฅๆๅปบๅบ็จๆ้็ๅธๅฑ๏ผๅนถไธ็ผๅๆดไผ่ดจ็ไปฃ็?ใ
            
            ๅๅฎนๆฅ่ช[ๆทฑๅฅไบ่งฃ Jetpack Compose ๅธๅฑ - YouTube](https://youtu.be/zMKMwh9gZuI)
            
            ## Composeๅธๅฑ็ณป็ป็็ฎๆ?
            
            - ็ฎๅๅธๅฑ็ๅๅปบ๏ผๅฐคๅถๆฏ่ชๅฎไนๅธๅฑ
            - ๆไพๅผบๅคง็ๅธๅฑ็ณป็ป
            - ๅฎ็ฐๅ่ถ็ๆง่ฝ
            
            ![image-20221209183304625](https://yorick.love/img/image-20221209183304625.png)
            
            **ๅฆไฝๅฎ็ฐไปฅไธ็ฎๆ?๏ผ**
            
            ## Jetpack Compose ๅฆไฝๅฐ็ถๆ่ฝฌไธบ็้ข
            
            ่ฟไธชๆต็จๅๅซไธไธช้ถๆฎต
            
            - ็ปๅ
            - ๅธๅฑ
            - ็ปๅถ
            
            ![image-20221209183505668](https://yorick.love/img/image-20221209183505668.png)
            
            ### ็ปๅ้ถๆฎต๏ผComposition๏ผ
            
            ็ปๅ้ถๆฎตไผๆง่กๅฏ็ปๅๅฝๆฐ๏ผ่ฟไบๅฝๆฐไผๅๅปบ็้ขๅนถ็ปๅปบ็้ขๆ?ใ
            
            ไพๅฆ๏ผๆง่ก่ฟไธชSearchResultๅฏ็ปๅๅฝๆฐ๏ผๅฐฑไผ็ๆ่ฟๆ?ทไธไธช็้ขๆ?ใ
            
            ![image-20221209184149125](https://yorick.love/img/image-20221209184149125.png)
            
            ๅฏ็ปๅ้กนๅๅซ้ป่พๅๆงๅถๆต๏ผๅจไธๅ็็ถๆไธไบง็ไธๅ็็้ขๆ?ใ
            
            ### ๅธๅฑ้ถๆฎต๏ผLayout๏ผ
            
            ๅธๅฑ้ถๆฎตไผ้ๅๆดไธช็้ขๆ?๏ผๆต้ๆฏไธช็้ขๅ็ด?ๅนถๅฐๅฎไปฌๆพ็ฝฎๅจๅฑๅนไธ็ไบ็ปด็ฉบ้ดใไนๅฐฑๆฏ่ฏด๏ผๆฏไธช่็นไผ็กฎๅฎๅถๅฎฝๅบฆๅ้ซๅบฆไปฅๅxๅyๅๆ?ใ
            
            ### ็ปๅถ้ถๆฎต๏ผDrawing๏ผ
            
            ็ปๅถ้ถๆฎตไผ้ๆฐ้ๅ็้ขๆ?ๅนถๅ็ฐๅจ้จๅ็ด?ใ
            
            ## ๅธๅฑ้ถๆฎต็ๆทฑๅฅไป็ป
            
            ๅธๅฑ้ถๆฎตๅๅซไธคไธช็ฏ่๏ผ
            
            - ๆต้๏ผMeasure๏ผ
            - ๆพ็ฝฎ๏ผPlace๏ผ
            
            ![image-20221209185018210](https://yorick.love/img/image-20221209185018210.png)
            
            ๅคง่ด็ธๅฝไบViewไธญ็`onMeasure`ๅ`onLayout`
            
            ไธ่ฟๅจComposeไธญ๏ผ่ฟไธคไธช็ฏ่ๆฏ็ธไบไบค็ป็๏ผๅ?ๆญคๆไปฌๆไธๅฐๅฎไปฌ่งไฝไธไธชๅธๅฑ็ฏ่ใ
            
            ็้ขๆ?ไธญๆฏไธช่็น็ๅธๅฑๆต็จๅๅซไธไธชๆญฅ้ชค๏ผ
            
            - ๅๆต้ๅจ้จๅญ้กน
            - ๅณๅฎ่ช่บซๅฐบๅฏธ
            - ๆพ็ฝฎๅญ้กน
            
            ![image-20221209185722752](https://yorick.love/img/image-20221209185722752.png)
            
            ๅทไฝ่ฟ็จๅฆไธ๏ผ
            
            ![image-20221209185904184](https://yorick.love/img/image-20221209185904184.png)
            
            ่ฟๆ?ทไปฅๆฅ๏ผ่ทๅธๅฑๅจ็กฎๅฎไบๆๆๅญ้กน็ๅฐบๅฏธๅไฝ็ฝฎๅ๏ผๅฐฑๅฏไปฅ็กฎๅฎ่ชๅทฑ็ๅฐบๅฏธๅไฝ็ฝฎ๏ผๆพ็ฝฎๆไปค๏ผ๏ผ็ถๅๅฐฑๅฏไปฅ่ฟๅฅๆพ็ฝฎ็ฏ่๏ผ็ณป็ป้ๆฐ้ๅ็้ขๆ?๏ผๅนถๆง่กๆๆๆพ็ฝฎๆไปคใ
            
            ไธ่ฟฐ่ฟ็จๅฆไฝๅฎ็ฐ๏ผ
            
            ๅฎ้ไธ๏ผๆฏไธช้ซ็บงๅซๅฏ็ปๅ้กน้ฝๆฏ้่ฟไฝ็บงๅซๅฏ็ปๅ้กนๆ้?่ๆ็ใ
            
            ![image-20221209190725298](https://yorick.love/img/image-20221209190725298.png)
            
            ๆฏไธไธชๅจๅฑๅนไธๆพ็ฝฎๅ็ด?็ๅฏ็ปๅ้กน้ฝๅๅซไบไธไธชๆๅคไธชLayoutๅฏ็ปๅ้กน๏ผ่ฟไธชLayoutๅฏ็ปๅ้กนๆฏCompose็้ข็ๅบ็กๆๅปบๅใ
            
            Layoutๅฏ็ปๅ้กนๅๅบLayoutNode๏ผๅจComposeไธญ๏ผ็้ขๆ?ๆ็ปๅๆฏLayoutNode็ๆ?ใ
            
            ![image-20221209190949564](https://yorick.love/img/image-20221209190949564.png)
            
            ไธ้ขๆฏ`Layout`็ๆบ็?
            
            ๅๆฐ๏ผ
            
            - content - ๅฏ็ปๅๆพ็ฝฎ็ๅญ้กนใ
            - modifier - ๅบ็จไบๅธๅฑ็ไฟฎ้ฅฐ็ฌฆใ
            - measurePolicy - ๅฎไนๅธๅฑ็ๆต้ๅๅฎไฝ็็ญ็ฅใ
            
            ```kotlin
            @Suppress("ComposableLambdaParameterPosition")
            @UiComposable
            @Composable inline fun Layout(
                content: @Composable @UiComposable () -> Unit, // The children composable to be laid out
                modifier: Modifier = Modifier, 				   // Modifiers to be applied to the layout
                measurePolicy: MeasurePolicy				   // The policy defining the measurement and positioning of the layout
            ) {
                val density = LocalDensity.current
                val layoutDirection = LocalLayoutDirection.current
                val viewConfiguration = LocalViewConfiguration.current
                ReusableComposeNode<ComposeUiNode, Applier<Any>>(
                    factory = ComposeUiNode.Constructor,
                    update = {
                        set(measurePolicy, ComposeUiNode.SetMeasurePolicy)
                        set(density, ComposeUiNode.SetDensity)
                        set(layoutDirection, ComposeUiNode.SetLayoutDirection)
                        set(viewConfiguration, ComposeUiNode.SetViewConfiguration)
                    },
                    skippableUpdate = materializerOf(modifier),
                    content = content
                )
            }
            ```
            
            ่ชๅฎไนLayout
            
            ```kotlin
            @Composable
            fun MyCustomLayout(
                modifier: Modifier = Modifier,
                content: @Composable () -> Unit
            ) {
                Layout(
                    modifier = modifier,
                    content = content
                ) {measurables:List<Measurable>,
                    constraints:Constraints ->
                    // TODO measure and place items
                }
            }
            ```
            
            ๅจๆฌไพ็MyCustomLayoutๅฏ็ปๅ้กนไธญ๏ผๆไปฌ่ฐ็จLayoutๅฝๆฐ๏ผๅนถไปฅๅฐพ้lambda็ๅฝขๅผๆไพmeasurePolicy็จไบๅฎ็ฐๆ้็ๆต้ๅฝๆฐ๏ผ่ฟไธชๅฝๆฐๆฅๅ`Constraints`ๅฏน่ฑก๏ผๅฎไนๅธๅฑ็ๅคงๅฐใ
            
            `Constraints`ๆฏไธไธช็ฎๅ็็ฑป๏ผ็จไบๅฏนๅธๅฑๅฏไปฅ้็จ็ๅฎฝๅบฆๅ้ซๅบฆไธไธ้่ฟ่กๅปบๆจกใ
            
            ```kotlin
            class Constraints {
                val minWidth: Int
                val maxWidth: Int
                val minHeight: Int
                val maxHeight: Int
            }
            ```
            
            ไพๅฆ๏ผ`Constrains`ๅฏไปฅ่กจ่พพๅธๅฑๅฏไปฅ้็จไปปๆๅฐบๅฏธ
            
            ```kotlin
            val bigAsYouLike = class Constraints(
                minWidth = 0,
                maxWidth = Constraints.Infinity,
                minHeight = 0,
                maxHeight = Constraints.Infinity,
            )
            ```
            
            ไนๅฏไปฅ่กจ่พพๅธๅฑๅฟ้กป้็จ็กฎๅ็ๅฐบๅฏธ
            
            ```kotlin
            val bigAsYouLike = class Constraints(
                minWidth = 50,
                maxWidth = 50,
                minHeight = 50,
                maxHeight = 50,
            )
            ```
            
            ๆต้ๅฝๆฐ่ฟไผๆฅๆถๅฏๆต้้กน็ๅ่กจ๏ผๆญคๅ่กจ่กจ็คบไผ?ๅฅ็ๅญ้กนๅ็ด?๏ผMeasurable็ฑปๅๅฌๅผ็จไบๆต้้กน็ฎ็ๅฝๆฐใ
            
            ๆฏไธชๅ็ด?็ๅธๅฑๆต็จๅทไฝๅฎ็ฐ๏ผ
            
            ```kotlin
            @Composable
            fun MyCustomLayout(
                modifier: Modifier = Modifier,
                content: @Composable () -> Unit
            ) {
                Layout(
                    modifier = modifier,
                    content = content
                ) {measurables:List<Measurable>,
                    constraints:Constraints ->
                    // ๆต้ๅไธชๅญ้กน๏ผไบง็ๅฏๆพ็ฝฎๅ่กจ
                    val palceables = measurables.map { measurable ->
                        // ๆง่กmeasurable็measureๆนๆณ๏ผๆญคๆนๆณๆฅๅๅฐบๅฏธ็บฆๆๆกไปถ
                        measurable.measure(constraints)
                    }
                    // ๅฏๆพ็ฝฎ้กนๆฏ็ป่ฟๆต้็ๅญ้กน๏ผ้ฝๆไธไธชๅฐบๅฏธ
                    // ไฝฟ็จๅฏๆพ็ฝฎ้กนๆฅ่ฎก็ฎๅธๅฑๅคงๅฐ
                    val width = // ไปpalceables่ฎก็ฎๅพๅฐ
                    val height = // ไปpalceables่ฎก็ฎๅพๅฐ
                    // ๆฅๅๅฐบๅฏธ
                    layout(width, height){
                        // layoutๆนๆณ้่ฆไธไธชๆพ็ฝฎไฝ็ฝฎๅๆฅๆพ็ฝฎๆฏไธช้กน็ฎ
                        placeables.forEach{ palceable ->
                            placeable.place( // ่ฟๆpalceRelativeๆนๆณ๏ผ้ๅฏนไปๅณๅๅทฆ็่ฏญ่จๅบๅ้ๅๆฐดๅนณๅๆ?
                                x = ...
                                y = ...
                            )
                        }
                    }
                }
            }
            ```
            
            placeๆนๆณไป่ฝ็จไบmeasureๆนๆณ่ฟๅ็ๆพ็ฝฎ้กน๏ผ่ฟๆ?ท็API่ฎพ่ฎกๅฏไปฅ้ฒๆญขๆพ็ฝฎๆฒกๆๆต้่ฟ็ๅ็ด?ใๅจViewไธญ๏ผonMeasureๅonLayout็่ฐ็จ้กบๅบๆฒกๆๅผบๅถๆง่ฆๆฑ๏ผๅฎนๆไบง็bugใ
            
            ็คบไพ๏ผๅฎ็ฐ่ชๅฎไนColum
            
            ```kotlin
            @Composable
            fun MyColum(
                modifier: Modifier = Modifier,
                content: @Composable () -> Unit
            ) {
                Layout(
                    modifier = modifier,
                    content = content
                ) { measurables: List<Measurable>,
                    constraints: Constraints ->
                    // ๆต้
                    val palceables = measurables.map { measurable ->
                        measurable.measure(constraints)
                    }
                    // ่ฎก็ฎ
                    val height = palceables.sumOf { it.height }
                    val width = palceables.maxOf { it.width }
                    // ๆพ็ฝฎ
                    layout(width, height) {
                        var y = 0
                        palceables.forEach { placeable ->
                            placeable.placeRelative(x = 0, y = y)
                            y += placeable.height
                        }
                    }
                }
            }
            ```
            
            ็คบไพ๏ผ
            
            ```kotlin
            @Composable
            fun VerticalGrid(
                modifier: Modifier = Modifier,
                columns:Int = 2,
                content: @Composable () -> Unit
            ){
                Layout(
                    modifier = modifier,
                    content = content
                ) { measurables,constraints->
                    // ๅๅฎฝ็ญไบๅธๅฑ็ๆๅคงๅฎฝๅบฆ้คไปฅๅๆฐ
                    val itemWidth = constraints.maxWidth / columns
                    // ๆ้?ๆฐ็constraintsๅฏน่ฑก
                    val itemConstraints = constraints.copy(
                        minWidth = itemWidth,
                        maxWidth = itemWidth
                    )
                    // ไฝฟ็จ็บฆๆๆกไปถๆต้ๆฏไธช้กน็ฎ
                    val palceables = measurables.map { measurable ->
                        measurable.measure(itemConstraints)
                    }
                    // ๅฐ้กน็ฎๆพๅฅ็ฝๆ?ผ
                    ...
                }
            }
            ```
            
            ่ฟ็งไธบๅญ้กนๅๅฎนๅๅปบๆฐ็บฆๆๆกไปถ็็ๅฟต๏ผๅฐฑๆฏๅฎ็ฐ่ชๅฎไนๆต้้ป่พ็ๆนๅผ๏ผ่ฝๅคๅๅปบไธๅ็บฆๆๆกไปถๆฅๆต้ๅญ้กน๏ผ่ฟๆฏ่ฟไธชๆจกๅ็ๅณ้ฎใ
            
            ![image-20221213213747607](https://yorick.love/img/image-20221213213747607.png)
            
            ๆๅ็ถ้กน7ไผ?้ไธ็ณปๅๅฏ้็ๅฐบๅฏธไพๅญ้กน้ๆฉ๏ผไธๆฆๅญ้กน้ๆฉไบ่ชๅทฑ็ๅฐบๅฏธ๏ผ็ถ้กนๅฐฑๅฟ้กปๆฅๅๅนถ่ฟ่กๅค็ใ
            
            ไผ็นๆฏๅฏไปฅ้่ฟๅๆฌกๆต้้ๅๆดไธช็้ขๆ?๏ผๅนถไธ็ฆๆญขๅคไธชๆต้ๅพช็ฏ๏ผๆต่ฏๅคๆฌกไผๆฅ้๏ผ๏ผ่ฟๆ?ทๅฏไปฅๆ้ซๆง่ฝ๏ผไพๅฆ็จๅจ็ปๆๆๅ็ฐๅธๅฑใ
            
            ```kotlin
            // try out different constraints
            val constraints1 = ...
            val constraints2 = ...
            val placeable1 = measurable.measure(constraints1)
            val placeable2 = measurable.measure(constraints2)
            ```
            
            ไปไนๆถๅ็จ่ชๅฎไนๅธๅฑ
            
            - ๆ?ๆณ็จๆ?ๅๅธๅฑๅฎ็ฐ
            - ้่ฆ็ฒพ็กฎๅ็ด?็ๆงๅถๆต้ๅๆพ็ฝฎ
            - ๅฎ็ฐๅธๅฑๅจ็ป
            - ้่ฆๆด้ซ็ๆง่ฝ
            
            ## Modifierไฟฎ้ฅฐ็ฌฆ
            
            Layoutๅฝๆฐๆฅๅไฟฎ้ฅฐ็ฌฆ้พไฝไธบๅๆฐ๏ผไฟฎ้ฅฐ็ฌฆไฟฎ้ฅฐ่ชๅทฑๆๅณ่ๅฐ็ๅ็ด?๏ผๅนถไธๅจๅธๅฑ่ช่ก่ฟ่กๆต้ๅๆพ็ฝฎไนๅๅไธๆต้ๅๆพ็ฝฎใ 
            
            ๅฆไฝๅฎ็ฐ๏ผ
            
            ๆๅพๅคๅฝฑๅไธๅ่กไธบ็ๅ็ฑปไฟฎ้ฅฐ็ฌฆ๏ผไพๅฆdrawingไฟฎ้ฅฐ็ฌฆ๏ผpointerInputไฟฎ้ฅฐ็ฌฆๅfocusไฟฎ้ฅฐ็ฌฆ๏ผๅๆไปฌๅฏๅ็ธๅณ็ๆฏLayoutModifierใ ๅฎๆไพไบmeasureๆนๆณ๏ผๆญคๆนๆณๅ?ไนไธLayout็ปๅ้กนๅฎๅจไธๆ?ท๏ผไฝๆฏๅฎๅชไฝ็จไบๅไธชๅฏๆต้้กน๏ผ่ไธๆฏๅฏๆต้้กนๅ่กจ๏ผๅ?ไธบไฟฎ้ฅฐ็ฌฆๅฐฑๆฏๅบ็จไบๅไธช้กน็ฎ็ ใ 
            
            ่ฟไธช็คบไพไธญ๏ผไฟฎ้ฅฐ็ฌฆๅฏๅๅธๅฑไธๆ?ทไฟฎๆน็บฆๆๆกไปถๆๅฎ็ฐ่ชๅฎไนๆพ็ฝฎ้ป่พใ่ฟๆๅณ็๏ผไฝ?ๅนถไธๆปๆฏ้่ฆ็ผๅ่ชๅฎไนๅธๅฑ๏ผๅฆๆๅช้่ฆไฝ็จไบๅไธช้กน็ฎ๏ผๅฐฑๅฏไปฅๆนไธบไฝฟ็จไฟฎ้ฅฐ็ฌฆใ
            
            ```kotlin
            interface LayoutModifier : Modifier.Element {
                
            fun MeasureScope.measure(
                measurable: Measurable,
                constraints: Constraints
            ): MeasureResult
                ...
            }
            ```
            
            ไพๅฆ๏ผๆไปฌ็็PaddingModifierๅฆไฝๅทฅไฝใ
            
            ```kotlin
            fun Modifier.padding(all: Dp) = 
                this.then(PaddingModifier(
                    start = all,
                    top = a1l,
                    end = all,
                    bottom = all
                    )
                )
            
            private class PaddingModifier(
                val start: Dp = 0.dp, 
                val top: Dp = 0.dp,
                val end: Dp = 0.dp,
                val bottom: Dp = 0.dp
            ) : LayoutModifier {
            ...
            }
            ```
            
            ## ้ซ็บงๅธๅฑๅ่ฝ
            
            ### ๅบๆๆต้ๅฑๆง๏ผIntrinsic Measurement๏ผ
            
            Composeไธๆปๆฏไฝฟ็จๅไผ?้ๅธๅฑ็ณป็ปใไพๅฆ๏ผไธๆๅ่กจ้่ฆไฝฟ็จๅบๆๆๅคงๅฎฝๅบฆๆฅ็กฎๅฎๅทไฝๅฐบๅฏธใ
            
            ```kotlin
            Column(Modifier.width(IntrinsicSize.Max)) {
                Text(Modifier.fillMaxWidth())
                Text(Modifier.fillMaxWidth()) 
                Text(Modifier.fillMaxWidth()) 
                Text(Modifier.fillMaxWidth()) 
                Text(Modifier.fillMaxWidth())
            }
            ```
            
            ไธๆๅ่กจ็ๅฎฝๅบฆ = ๆฏไธชๆๆฌไธๆข่ก็ๆๅตไธ็ๆๅคงๅฎฝๅบฆ
            
            ๆๆฌ็ๆๅฐๅบๆๅฎฝๅบฆๆฏๆฏ่กไธไธชๅ่ฏ็ๅฎฝๅบฆ๏ผๅคไบไผๆข่กใ
            
            ### ParentDataไฟฎ้ฅฐ็ฌฆ
            
            ๆไธชๅธๅฑ่กไธบ้่ฆไปๅญ้กน่ทๅไฟกๆฏ๏ผๅฐฑ้่ฆไฝฟ็จParentDataใ
            
            Boxไธญ็alignๅฐฑๆฏParentDataไฟฎ้ฅฐ็ฌฆ๏ผๅฎๅ็ถ้กนไผ?้ไฟกๆฏ๏ผไพ็ถ้กน็กฎๅฎๅญ้กนๅธๅฑ๏ผๅฆๆไธๅจBoxไธญ๏ผๅฐฑๆ?ๆณไฝฟ็จใ
            
            ๅบ็บฟๅฏน้ฝ
            
            ![image-20221214113056005](https://yorick.love/img/image-20221214113056005.png)
            
            ๅฏน้ฝไผ็ฉฟ้่ณๅญ้กน
            
            ![image-20221214113124913](https://yorick.love/img/image-20221214113124913.png)
            
            ### BoxWithConstraints
            
            ่ฟๆฏไธไธช็ฑปไผผBox็ๅฏ็ปๅ้กน๏ผไฝๆฏๅฎไผๅฐๅฏนๅถๅๅฎน็็ปๅๆไฝไธ็ดๅปถ่ฟๅฐๅธๅฑ็ฏ่๏ผ้ฃๆถๅฐฑๆๅธๅฑไฟกๆฏๅฏ็จไบใ
            
             BoxWithConstraintsไธญ็ๅๅฎนๅจๅฌๅผ็บฆๆๆกไปถ็ๆฅๆถๅจไฝ็จๅไธญ่ฟ่ก๏ผ่ฟไบ็บฆๆๆกไปถๆฏๅจๅธๅฑ็ฏ่ไปฅๅ็ด?ๆDPIๅผ็กฎๅฎ็๏ผๅ?ๆญค๏ผ้้ข็ๅๅฎนๅฏไปฅไฝฟ็จ่ฟไบ็บฆๆๆกไปถๆฅ้ๆฉ่ฆ็ปๅ็ๅๅฎนใ
            
            ไพๅฆ๏ผๆ?นๆฎๆๅคงๅฎฝๅบฆ้ๆฉไธๅ็ๅ็ฐๅๅฎนใ
            
            ```kotlin
            @Composable
            fun MyApp(...) { 
                BoxWithConstraints() { // this: BoxWithConstraintsScope 
                    when {
                        maxWidth < 400.dp -> CompactLayout()
                        maxWidth < 800.dp -> MediumLayout()
                        else -> LargeLayout()
                    }
                }
            }
            ```
            
            ไฝๆฏBoxWithConstraintsไผๅจๅธๅฑ้ถๆฎตๅฏๅจๅญ็ปๅ๏ผ่ฟไผๅฝฑๅๆง่ฝใ้ค้ไฟกๆฏ็็ฑปๅไผ้็ๅคงๅฐไธ่ตทๆนๅ๏ผ่ฏทๅฐฝ้้ฟๅไฝฟ็จBoxWithConstraintsใ![image-20221214114817861](https://yorick.love/img/image-20221214114817861.png)
            
            ## ๆง่ฝ
            
            - ๅชๆๅจๆนๅๆพ็คบๅๅฎนๆถๆ้่ฆ้็ป๏ผ่ๆนๅๆพ็คบไฝ็ฝฎๆๆพ็คบๆนๆณๆถๅไธ้่ฆใ
            - ้ค้ไฟกๆฏ็็ฑปๅไผ้็ๅคงๅฐไธ่ตทๆนๅ๏ผ่ฏทๅฐฝ้้ฟๅไฝฟ็จBoxWithConstraintsใ
            - ๆๆถๆ?้ๆต้่ชๅทฑ็ๆๆๅญ้กนๆฅ็กฎๅฎๅธๅฑๅคงๅฐ
            """.replace("^", "$").trimIndent(),
            category = LocalCategoriesDataProvider.getCategoryById(1L),
            tag = listOf(1L, 2L, 3L).map { LocalTagsDataProvider.getTagById(it) },
            isStarred = true,
            createdAt = "13 mins ago"
        ),
        Note(
            id = 2L,
            author = LocalAccountsDataProvider.getContactAccountById(11L),
            subject = "Kotlin้ๅไธๆฐ็ป",
            body = """
                # Kotlin้ๅไธๆฐ็ป
                                
                ## List้ๅ
                
                ### List็ๅๅปบไธๅ็ด?่ทๅ
                
                ```kotlin
                fun main() {
                    // ๅๅปบList
                    val list = listOf("Yorick", "Jerry", "Sandy")
                    // ๆฎ้่ทๅ
                    println(list[2])
                    // ไฝฟ็จๅฎๅจ็ดขๅผๅฝๆฐ่ทๅ
                    // getOrElse:ๆฒกๆๅ่ฟๅlambda่กจ่พพๅผ็็ปๆ
                    println(list.getOrElse(3){"Nothing"})
                    // getOrNull:ๆฒกๆๅ่ฟๅ็ฉบ
                    println(list.getOrNull(3))
                    // getOrNull้ๅๅๅนถๆไฝ็ฌฆไฝฟ็จ
                    println(list.getOrNull(3)?:"Nothing")
                }
                ```
                
                ### ๅฏๅๅ่กจ
                
                ๅจKotlinไธญ๏ผๆฏๆไฟฎๆนๅๅฎน็ๅ่กจๅซๅฏๅๅ่กจ๏ผ่ฆๅๅปบๅฏๅๅ่กจ๏ผๅฏไปฅไฝฟ็จmutableListOfๅฝๆฐใList่ฟๆฏๆไฝฟ็จtoListๅtoMutableListๅฝๆฐๅจๆๅฎ็ฐๅช่ฏปๅ่กจๅๅฏๅๅ่กจ็็ธไบ่ฝฌๆขใ
                
                ```kt
                fun main() {
                    // ๅๅปบๅฏๅๅ่กจ
                    val mutableList = mutableListOf("Yorick", "Jerry", "Sandy")
                    mutableList.add("Jack")
                    mutableList.remove("Jerry")ใ
                    // ็ธไบ่ฝฌๆข
                    listOf("Yorick", "Jerry", "Sandy").toMutableList()
                    mutableList.toList()
                }
                ```
                
                ### mutatorๅฝๆฐ
                
                ่ฝไฟฎๆนๅฏๅๅ่กจ็ๅฝๆฐๆไธช็ปไธ็ๅๅญ๏ผmutatorๅฝๆฐ
                
                ๆทปๅ?ๅ็ด?่ฟ็ฎ็ฌฆไธๅ?้คๅ็ด?่ฟ็ฎ็ฌฆ
                
                ๅบไบlambda่กจ่พพๅผๆๅฎ็ๆกไปถๅ?้คๅ็ด?
                
                
                ```kt
                fun main() {
                    // ๅๅปบๅฏๅๅ่กจ
                    val mutableList = mutableListOf("Yorick", "Jerry", "Sandy")
                    mutableList += "Morty" // ็ธๅฝไบadd
                    mutableList -= "Sandy" // ็ธๅฝไบremove
                    mutableList.removeIf{it.contains("o")} // ๆปก่ถณๆกไปถๆ็งป้ค
                    println(mutableList)
                }
                ```
                
                ### ้ๅ้ๅ
                
                - for in ้ๅ
                
                - forEach ้ๅ
                
                - forEachIndexed ้ๅๆถ่ฆ่ทๅ็ดขๅผ
                
                ```kt
                fun main() {
                    val list = listOf("Yorick", "Jerry", "Sandy")
                    for (s in list) {
                        println(s)
                    }
                
                    list.forEach {
                        println(it)
                    }
                
                    list.forEachIndexed { index, item ->
                        println("^index : ^item")
                    }
                }
                ```
                
                ### ่งฃๆ
                
                ```kt
                fun main() {
                    val list = listOf("Yorick", "Jerry", "Sandy")
                    // ่งฃๆ่ตๅผ
                    val (origin,dest,proxy) = list
                    println("^origin ^dest ^proxy")
                }
                ```
                ๅฝๆณ่ทณ่ฟๆไธชๅ็ด?๏ผๅ็จไธๅ็บฟไปฃๆฟใ
                ```kt
                val (origin, _, proxy) = list
                println("^origin ^proxy")
                // ่พๅบ
                // Yorick Sandy
                ```
                
                ## Set้ๅ
                
                ้่ฟsetOfๅๅปบset้ๅ๏ผไฝฟ็จelementAtๅฝๆฐ่ฏปๅ้ๅไธญ็ๅ็ด?ใ
                
                ### Setๅๅปบไธๅ็ด?่ทๅ
                
                setOf๏ผๅๅปบ้ๅ
                elementAt๏ผ่ทๅ้ๅ
                
                ```kt
                fun main() {
                    // ้ๅคๅ็ด?่ชๅจ่ฆ็
                    val set = setOf("Yorick", "Jerry", "Sandy","Yorick")
                    println(set.elementAt(2)) // Sandy
                }
                ```
                
                ### ๅฏๅ้ๅ
                
                ้่ฟmutableSetOfๅๅปบๅฏๅ็set้ๅ
                
                ```kt
                fun main() {
                    val mutableSet = mutableSetOf("Yorick", "Jerry", "Sandy", "Yorick")
                    mutableSet += "Morty"
                    mutableSet.forEach {
                        println(it)
                    }
                }
                ```
                
                ### ้ๅ่ฝฌๆขๅๅฟซๆทๅป้
                
                ```kt
                fun main() {
                    // ้่ฟ้ๅ่ฝฌๆขๅฝๆฐๅป้
                    val list = listOf("Yorick", "Jerry", "Sandy", "Yorick")
                        .toSet()
                        .toList()
                    println(list)
                    // ๅฟซๆทๆไฝ
                    println(listOf("Yorick", "Jerry", "Sandy", "Yorick").distinct())
                }
                // ้ฝ่พๅบ
                // [Yorick, Jerry, Sandy]
                ```
                
                ## ๆฐ็ป
                
                Kotlinๆไพๅ็งArray๏ผ่ฝ็ถๆฏๅผ็จ็ฑปๅ๏ผไฝๅฏไปฅ็ผ่ฏๆJavaๅบๆฌๆฐๆฎ็ฑปๅใ
                
                
                | ๆฐ็ป็ฑปๅ     | ๅๅปบๅฝๆฐ       |
                | ------------ | -------------- |
                | lntArray     | intArrayOf     |
                | DoubleArray  | doubleArrayOf  |
                | LongArray    | longArrayOf    |
                | ShortArray   | shortArrayOf   |
                | ByteArray    | byteArrayOf    |
                | FloatArray   | floatArrayOf   |
                | BooleanArray | booleanArrayOf |
                | Array        | arrayOf        |
                
                ```kt
                fun main() {
                    val intArrayOf = intArrayOf(1, 4, 2, 4, 6, 7)
                    // listๅฏไปฅ็ดๆฅ่ฝฌๆขไธบarray
                    listOf(10, 20, 30).toIntArray()
                    // ๅฏน่ฑกๆฐ็ป
                    val arrayList = arrayListOf(File("xxx"), File("yyy"), File("zzz"))
                }
                ```
                ## Map
                
                ### Map็ๅๅปบ
                ไฝฟ็จmapOfๅๅปบMap
                ```kt
                fun main() {
                    // ๅๅปบMap
                    val map = mapOf("Yorick" to 21, "Lily" to 20, "Jerry" to 17)
                    // ็ญไปทๆนๅผ
                    mapOf(Pair("Yorick", 21), Pair("Lily", 20))
                }
                ```
                
                ### ่ฏปๅMap็ๅผ
                
                - `[]`ๅๅผ่ฟ็ฎ็ฌฆ๏ผ่ฏปๅ้ฎๅฏนๅบ็ๅผ๏ผๅฆๆ้ฎไธๅญๅจๅฐฑ่ฟๅnull
                - `getValue`๏ผ่ฏปๅ้ฎๅฏนๅบ็ๅผ๏ผๅฆๆ้ฎไธๅญๅจๅฐฑๆๅบๅผๅธธ
                - `getOrElse`๏ผ่ฏปๅ้ฎๅฏนๅบ็ๅผ๏ผๆ่ไฝฟ็จๅฟๅๅฝๆฐ่ฟๅ้ป่ฎคๅผ
                - `getOrDefault`๏ผ่ฏปๅ้ฎๅฏนๅบ็ๅผ๏ผๆ่่ฟๅ้ป่ฎคๅผ
                
                ```kt
                fun main() {
                    val map = mapOf("Yorick" to 21, "Lily" to 20, "Jerry" to 17)
                    println(map["Yorick"]) // 21
                    println(map.getValue("Yorick")) // 21
                    println(map.getOrElse("Rose") { "NOTHING" }) // NOTHING
                    println(map.getOrDefault("Rose",0)) // 0
                }
                ```
                
                ### Map็้ๅ
                
                ่ฟๆฏ็จforEach
                
                ```kt
                fun main() {
                    val map = mapOf("Yorick" to 21, "Lily" to 20, "Jerry" to 17)
                    // ้ๅMap
                    map.forEach {
                        println("^{it.key} : ^{it.value}")
                    }
                    map.forEach { (key: String, value: Int) ->
                        println("^key : ^value")
                    }
                }
                // ้ฝ่พๅบ
                // Yorick : 21
                // Lily : 20
                // Jerry : 17
                ```
                
                ### ๅฏๅMap
                
                ```kt
                fun main() {
                    val mutableMap = mutableMapOf("Yorick" to 21, "Lily" to 20, "Jerry" to 17)
                    mutableMap += "Morty" to 16
                    // ไฝฟ็จputๅขๅ?
                    mutableMap.put("Morty", 15)
                    // ่ทๅไธๅฐๅๆพๅฅ
                    mutableMap.getOrPut("kimmy") { 11 }
                }
                ```
                
                ## Stack
                
                ไฝฟ็จkotlinๅฎ็ฐStackไธLinkedList
                
                [KotlinไธญStackไธLinkedList็ๅฎ็ฐๆนๆณ็คบไพ - ่พ่ฎฏไบๅผๅ่็คพๅบ-](https://cloud.tencent.com/developer/article/1741702)
                """.replace("^", "$").trimIndent(),
            category = LocalCategoriesDataProvider.getCategoryById(0L),
            tag = listOf(1L, 2L, 3L).map { LocalTagsDataProvider.getTagById(it) },
            isStarred = true,
            createdAt = "20 mins ago"
        ),
        Note(
            id = 3L,
            author = LocalAccountsDataProvider.getContactAccountById(2L),
            subject = "Java้ๅ",
            body = """
                # Java้ๅ

                Java้ๅๅฐฑๅไธ็งๅฎนๅจ๏ผๅฏไปฅๆๅคไธชๅฏน่ฑก็ๅผ็จๆพๅฅๅฎนๅจไธญใ  

                Java้ๅ็ฑปๅฏไปฅ็จไบๅญๅจๆฐ้ไธ็ญ็ๅคไธชๅฏน่ฑก๏ผ่ฟๅฏ็จไบไฟๅญๅทๆๆ?ๅฐๅณ็ณป็ๅณ่ๆฐ็ปใ

                Java้ๅๅฏๅไธบ SetใList ๅ Map ไธ็งไฝ็ณป
                - Set๏ผๆ?ๅบใไธๅฏ้ๅค็้ๅ
                - List๏ผๆๅบใๅฏ้ๅค็้ๅ
                - Map๏ผๅทๆๆ?ๅฐๅณ็ณป็้ๅ

                ๅจJava5ไนๅ๏ผJava้ๅไผไธขๅคฑๅฎนๅจไธญๆๆๅฏน่ฑก็ๆฐๆฎ็ฑปๅ๏ผๆๆๆๅฏน่ฑก้ฝๅฝๆObject็ฑปๅๅค็๏ผไปJava5ๅขๅ?ไบ**ๆณๅ**ไปฅๅ๏ผJava้ๅๅฏไปฅ่ฎฐไฝๅฎนๅจไธญๅฏน่ฑก็ๆฐๆฎ็ฑปๅใ

                ![JavaAssemble](https://yorick.love/img/javaAssemble.png)

                ### Collection

                ๅๅปบไธไธชCollectionๆฅๅฃ็ๅฏน่ฑก

                ```java
                Collection collection = new ArrayList();
                ```

                #### ๆทปๅ?ๅ็ด?

                1. `add()`ๅๆฐไธบ่ฆๆทปๅ?็ๅ็ด?ๅฏน่ฑก
                    ```java
                    collection.add(new Person());
                    ```
                2. `addAll()`ๅๆฐไธบ่ฆๆทปๅ?็้ๅๅฏน่ฑก
                    ```java
                    Collection collection2 = new ArrayList();
                    collection2.add(new Person());
                    collection2.add(new Person());
                    collection.addAll(collection2);
                    ```

                #### ่ฎฟ้ฎ้ๅ็ๆนๆณ

                1. `size()`่ทๅ้ๅ้ฟๅบฆ
                    ```java
                    System.out.println(collection.size());
                    ```
                2. `iterator()`ๅฏน้ๅ่ฟ่ก้ๅ๏ผ`iterator()`ๅฏไปฅๅพๅฐๅฏนๅบ็`Iterator`ๅฏน่ฑกใ
                   `Iterator`:่ฟญไปฃๅจ
                   ไฝฟ็จๆนๆณ๏ผ
                    ```java
                    //่ทๅIteratorๆฅๅฃๅฏน่ฑก
                    Iterator iterator = collection.iterator();
                    //ไฝฟ็จwhileๅพช็ฏๅIterator้ๅ้ๅ็ๆฏไธไธชๅ็ด?ใ
                    //ๅทไฝไฝฟ็จIteratorๆฅๅฃ็hasNext()ๅnext()ๆนๆณใ
                    while (iterator.hasNext()){
                        Object obj = iterator.next();
                        System.out.println(obj);
                    }
                    ```
                1. ไฝฟ็จๅขๅผบforๅพช็ฏ็ๆนๅผๆฅๅฏน้ๅ่ฟ่ก้ๅ
                    ```java
                    for(Object obj: collection){
                        System.out.println(obj);
                    }
                    ```
                #### ็งป้ค้ๅไธญ็ๅ็ด?
                1. `remove()`็งป้คๆไธไธชๆๅฎ็ๅฏน่ฑกใ้่ฟ`equals()`ๆนๆณๆฅๅคๆญ่ฆ็งป้ค็้ฃไธชๅ็ด?ๅจ้ๅไธญๆฏๅฆๅญๅจ๏ผไปฅๅๆฏๅฆ่ฝๅคๆๅ็งป้คใๅๆฐไธบ่ฆ็งป้ค็ๅ็ด?ๅฏน่ฑก๏ผ่ฟๅๆฏๅฆๆๅ็ๅธๅฐๅผใ  
                    ```java
                    boolean result = collection.remove(new Person());
                    System.out.printIn(result);
                    //่ฟๅ๏ผfalse
                    ```
                2. `removeAll()`ๅๆฐไธบ่ฆ็งป้ค็ๅ็ด?้ๅๅฏน่ฑกใ
                    ```java
                    boolean result = collection.removeAll(collection2);
                    System.out.printIn(result);
                3. `clear()`ไฝฟ้ๅๅ็ด?็ฝฎ็ฉบใ
                   ```java
                   collection.clear()
                   ```
                #### ๆฃๆต้ๅ็ๆนๆณ
                1. `contains()`ๆฃๆต้ๅๆฏๅฆๅๅซๆไธๅ็ด?
                   ```java
                   System.out.println(collection.contains(new Person()));
                   //่ฟๅ๏ผfalse
                   ```
                2. `containsAll()`ๆฃๆต้ๅๆฏๅฆๅๅซๆไธๅ็ด?้ๅ
                   ```java
                   System.out.println(collection.containsAll(collection2));
                   ```
                3. `isEmpty()`ๆฃๆต้ๅๆฏๅฆไธบ็ฉบ
                   ```java
                   System.out.println(collection.isEmpty());//false
                   collection.clear();
                   System.out.println(collection.isEmpty());//true
                   ```
                #### ้ๅ็ๅถไปๆนๆณ
                1. `toArry()`
                    ```java
                    Object [] objects = collection.toArray();
                    System.out.println(objects.length);
                    ```
                2. `toArry(T[])`ๆถๅๆณๅ
                3. `equals()`ๆฏ่พไธค้ๅๆฏๅฆ็ธ็ญ
                   ```java
                   //ๆๅบ้ๅ
                   Collection collection3 = new ArrayList();
                   collection3.add(p1);
                   collection3.add(p2);
                   Collection collection4 = new ArrayList();
                   collection4.add(p2);
                   collection4.add(p1);
                   System.out.println(collection3.equals(collection4));
                   //่ฟๅfalse
                   
                   //ๆ?ๅบ้ๅ
                   Collection collection3 = new HashSet();
                   collection3.add(p1);
                   collection3.add(p2);
                   Collection collection4 = new HashSet();
                   collection4.add(p2);
                   collection4.add(p1);
                   System.out.println(collection3.equals(collection4));
                   //่ฟๅtrue
                   ```
                4. `hasCode()`
                5. ไฝฟ็จๅขๅผบforๅพช็ฏ็ๆนๅผๆฅๅฏน้ๅ่ฟ่ก้ๅ
                   ```java
                   for (Object obj : collection) {
                       System.out.println(obj);
                       }
                   ```

                ### Set

                1. Setๆฏ Collection ็ๅญๆฅๅฃ
                2. Setไธญไธๅ่ฎธๅญๆพ็ธๅ็ๅ็ด?ใ
                3. ๅคๅฎ็ธๅๅ็ด?็ๆ?ๅๆฏ๏ผไธคไธชๅฏน่ฑก**ๅ**่ฐ็จ`equals()`ๆนๆณ๏ผ่ฟๅ`true`ใ

                #### HashSet

                HashSetๆฏSetๆฅๅฃ็ๅธๅๅฎ็ฐใ

                ๅบๆฌ็นๅพ๏ผ
                1. ไธ่ฝไฟ่ฏๅ็ด?็ๆๅ้กบๅบ๏ผๆ?ๅบ๏ผ
                2. HashSet ไธๆฏ็บฟ็จๅฎๅจ็
                3. ้ๅๅ็ด?ๅฏไปฅไฝฟ`null`
                   ```java
                   Set set = new HashSet();
                   set.add(null);
                   System.out.println(set.size());
                   //่พๅบ1
                   ```
                4. ๅฏนไบ HashSet๏ผๅฆๆไธคไธชๅฏน่ฑก้่ฟ`equals()`ๆนๆณ่ฟๅ true๏ผ่ฟไธคไธชๅฏน่ฑก็ hashCode ๅผไนๅบ่ฏฅ็ธๅใ
                   ```java
                   
                   set.add(new Person("xx",12));
                   set.add(new Person("xx",12));
                   System.out.println(set.size());
                   //ๆญฃๅธธๆๅตไธ่พๅบ4๏ผไธคไธชๅฏน่ฑกไธ็ธๅ
                   //ๅจPerson็ฑปไธญ้ๅequalsๆนๆณๅhashcodeๆนๆณ
                   @Override
                   public boolean equals(Object o) {
                        if (this == o) return true;
                        if (o == null || getClass() != o.getClass()) return false;
                        Person person = (Person) o;
                        return age == person.age && name.equals(person.name);
                   }
                   
                   @Override
                   public int hashCode() {
                        return Objects.hash(name, age);
                   }
                   //้ๅๅ่ฟๅ3
                   ```
                5. ็ฑๆ?นๆฎๅ็ด?่ช่บซๅฑๆง่ฎก็ฎ็ hashCode ๅณๅฎไฝ็ฝฎ๏ผๆไปฅๅฏ้ๅhashCodeๅฎ็ฐ้ๅค๏ผไธๆจ่๏ผๅๆๅบ็ฑปไผผ LinkedHashSet
                   ```java
                    //ๅจPerson็ฑปไธญ้ๅhashCodeๆนๆณ
                    private static int init = 0;
                    @Override
                    public int hashCode() {
                        return init++;
                    }
                   ```

                #### LinkedHashSet

                1. LinkedHashSet ๆฏ HashSet ็ๅญ็ฑป
                2. ไฝฟ็จ้พ่กจ็ปดๆคๅ็ด?็ๆฌกๅบ๏ผ่ฟไฝฟๅพๅ็ด?็่ตทๆฅๆฏไปฅๆๅฅ้กบๅบไฟๅญ็๏ผไนๅ?ๆญคๆง่ฝ็จๅผฑ
                3. LinkedHashset ไธๅ่ฎธ้ๅๅ็ด?้ๅค
                4. ้ๅ็ฑป็`hashCode()`ๆนๆณไนๅฏไปฅๅจ HashSet ๅฎ็ฐๅบๅๅ

                #### TreeSet

                TreeSetๆฏSortedSetๆฅๅฃ็ๅฎ็ฐ็ฑป๏ผTreeSetๅฏไปฅ็กฎไฟ้ๅๅ็ด?ๅคไบๆๅบ็ถๆ

                ##### ่ช็ถๆๅบ

                TreeSet ไผ่ฐ็จ้ๅๅ็ด?็`compareTo(Object obj)`ๆนๆณๆฅๆฏ่พๅ็ด?ไน้ด็ๅคงๅฐๅณ็ณป๏ผ็ถๅๅฐ้ๅๅ็ด?ๆๅๅบๆๅๅฆๆ่ฏๅพๆไธไธชๅฏน่ฑกๆทปๅ?ๅฐ TreeSet ๆถ๏ผๅ่ฏฅๅฏน่ฑก็็ฑปๅฟ้กปๅฎ็ฐ Comparable ๆฅๅฃใ

                ๅฎ็ฐ Comparable ็็ฑปๅฟ้กปๅฎ็ฐ`compareTo(Object obj)`ๆนๆณ๏ผไธคไธชๅฏน่ฑกๅณ้่ฟ`compareTo(Object obj)`ๆนๆณ็่ฟๅๅผๆฅๆฏ่พๅคงๅฐ๏ผ่ฟๅๅผ็ฑปๅไธบint๏ผๆญฃๆฐ่กจ็คบๅฝๅๅ็ด?ๅคง๏ผ่ดๆฐ่กจ็คบๅๆฐๅ็ด?ๅคง๏ผ่ฟๅ0ไปฃ่กจไธคๅ็ด?็ธ็ญใ
                ```java
                //ๅฎ็ฐComparableๆฅๅฃ
                public class Students implements Comparable {
                    private String name;
                    public int score;

                    public Students(String name, int score) {
                        this.name = name;
                        this.score = score;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getScore() {
                        return score;
                    }

                    public void setScore(int score) {
                        this.score = score;
                    }
                }
                ```

                1. ๅ?ไธบๅชๆ็ธๅ็ฑป็ไธคไธชๅฎไพๆไผๆฏ่พๅคงๅฐ๏ผๆไปฅๅ TreeSet ไธญๆทปๅ?็ๅบ่ฏฅๆฏ**ๅไธไธช็ฑป**็ๅฏน่ฑก๏ผๅฆๅๅฏ่ฝๅ็็ฑปๅ่ฝฌๆขๅผๅธธใ

                2. ๅฝ้่ฆๆไธไธชๅฏน่ฑกๆพๅฅ TreeSet ไธญ,้ๅ่ฏฅๅฏน่ฑกๅฏนๅบ็`equals()`ๆนๆณๆถ๏ผๅบไฟ่ฏ่ฏฅๆนๆณไธ`compareTo(Object obj)`ๆนๆณๆไธ่ด็็ปๆ๏ผๅฆๆไธคไธชๅฏน่ฑก้่ฟ`equals()`ๆนๆณๆฏ่พ่ฟๅ`true`๏ผๅ้่ฟ`compareTo(Object obj)`ๆนๆณๆฏ่พๅบ่ฟๅ`0`ใ
                   ```java
                   public int compareTo(Object o) {
                        if (o instanceof Students) {
                            Students stu = (Students) o;
                            return this.score - stu.score;//ๅๆฐๅๅบๆ
                            return - this.score + stu.score;//ๅๆฐ้ๅบๆ
                            //return -this.name.compareTo(stu.name);//ๆnameๅญๆฏ้กบๅบ้ๅบๆ
                        } else {
                            throw new ClassCastException("ไธๆฏไธไธชStudentๅฏน่ฑก");
                        }
                    }
                   ```

                ##### ๅฎๅถๆๅบ

                ๅๅปบ TreeSet ๅฏน่ฑกๆถ๏ผไผ?ๅฅ Comparator ็ๆฅๅฃๅฎ็ฐ็ฑปใ
                ```java
                Comparator comparator = new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        if (o1 instanceof Person && oinstanceof Person) {
                            Person p1 = (Person) o1;
                            Person p2 = (Person) o2;
                            return -p1.getAge() + p2.getAge;//ๅนด้พ้ๅบ
                        } else {
                            throw new ClassCastException("ไธ่ฝ่ฝฌไธบ Person");
                        }
                    }
                };
                Set set1 = new TreeSet<>(comparator);
                set1.add(new Person("AA", 12));
                set1.add(new Person("AA", 15));
                set1.add(new Person("AA", 9));
                set1.add(new Person("AA", 16));

                for (Object p : set1) {
                    System.out.println(p);
                }
                //่พๅบ๏ผ
                //Person{name='AA', age=16}
                //Person{name='AA', age=15}
                //Person{name='AA', age=12}
                ///Person{name='AA', age=9}
                ```
                ่ฟๆ?ทPersonๅฐฑไธ้่ฆๅฎ็ฐ`compareTo`ๆฅๅฃ
                ่ฆๆฑ๏ผComparator ๆฅๅฃ็`compare()`ๆนๆณ็่ฟๅๅผๅไธคไธชๅ็ด?็`equals()`่ฆไธ่ดใ

                ### List
                1. List ไปฃ่กจไธไธชๅ็ด?ๆๅบใไธๅฏ้ๅค็้ๅ๏ผ้ๅไธญ็ๆฏไธชๅ็ด?้ฝๆๅถๅฏนๅบ็้กบๅบ็ดขๅผใ
                2. List ๅ่ฎธไฝฟ็จ้ๅคๅ็ด?๏ผๅฏไปฅ้่ฟ็ดขๅผๆฅ่ฎฟ้ดๆๅฎไฝ็ฝฎ็้ๅๅ็ด?ใ
                3. List ้ป่ฎคๆๅ็ด?็ๆทปๅ?้กบๅบ่ฎพ็ฝฎๅ็ด?็็ดขๅผใ

                ๆนๆณ๏ผ
                ```java
                - void add(int index, Objed ele)
                //ๅฐๅ็ด?ๆๅฅๅฐๆๅฎไฝ็ฝฎ
                - boolean addAll(int index, Collection eles)
                //ๅฐ้ๅๆๅฅๅฐๆๅฎไฝ็ฝฎ
                - Object get(int index)
                //่ทๅๆๅฎไฝ็ฝฎ็ๅฏน่ฑก
                - int indexOf(Objed obj)
                //่ทๅๆๅฎๅ็ด?็็ดขๅผ๏ผ็จequalsๆนๆณๅคๅฎ๏ผ้ๅคๅ็ด?ๅ็ฌฌไธไธชใ
                - int lastIndexOf(Objed obj)
                //้ๅคๅ็ด?ๅๆๅไธไธช
                - Object remove(int index)
                //็งป้คๆๅฎไฝ็ฝฎ็ๅฏน่ฑก
                - Object set(int index,Objed ele) 
                //ๆฟๆขๆๅฎไฝ็ฝฎๅ็ด?
                - List subList(int fromlndex, int tolndex) 
                //ๅๅบ้ดๅๅ็ด?๏ผๅ้ญๅๅผ
                List list2 = list.subList(2, 5);//2,3,4
                for (Object obj : list2) {
                    System.out.println(obj);
                }
                ```

                List้ขๅคๆไพไบไธไธชlistIterator()ๆนๆณ๏ผ่ฏฅๆนๆณ่ฟๅไธไธชListLteratorๅฏน่ฑก๏ผListeratorๆฅๅฃ็ปงๆฟไบIteratorๆฅๅฃ๏ผๆไพไบไธ้จๆไฝList็ๆนๆณ๏ผ
                ```java
                - boolean hasPrevious()
                - Object previous()
                - void add()
                ```

                ArrayListๆฏListๆฅๅฃ็ๅธๅๅฎ็ฐ
                ```java
                List list = new ArrayList();
                ```

                ้ๅ๏ผ
                ```java
                //ไฝฟ็จIterator
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
                //ไฝฟ็จๅขๅผบforๅพช็ฏ
                for (Object o : list) {
                    System.out.println(o);
                }
                //ไฝฟ็จforๅพช็ฏๅList็get(int)ๆนๆณ
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
                //ไฝฟ็จListIterator
                ListIterator lit = list.listIterator();
                while (lit.hasNext()) {
                    System.out.println(lit.next());
                }
                ```
                VectorไนๆฏListๆฅๅฃ็่ฟๅคๅธๅๅฎ็ฐ๏ผ่ฝ็ถ็บฟ็จๅฎๅจไฝๆฏไธๆจ่ไฝฟ็จใ

                Arrays.asList(...)ๆนๆณ่ฟๅ็ List ้ๅๆขไธๆฏ ArrayListๅฎไพ๏ผไนไธๆฏVectorๅฎไพใArrays.asL.ist(...)่ฟๅๅผๆฏไธไธชๅบๅฎ้ฟๅบฆ็ List้ๅใ
                ```java
                System.out.println(Arrays.asList(new Person("MM",23),
                new Person("NN",22)));
                //[Person{name='MM', age=23}, Person{name='NN', age=22}]
                ```

                ### Map
                - Map็จไบไฟๅญๅทๆๆ?ๅฐๅณ็ณป็ๆฐๆฎ๏ผๅ?ๆญคMap้ๅ้ไฟๅญ็ไธค็ปๅผ๏ผไธ็ปๅผ็จไบไฟๅญMap้็ Key๏ผๅฆๅคไธ็ป็จไบไฟๅญMap้็Valueใ
                - Mapไธญ็ key ๅ value ้ฝๅฏไปฅๆฏไปปไฝๅผ็จ็ฑปๅ็ๆฐๆฎ
                - **Mapไธญ็ Key ไธๅ่ฎธ้ๅค**๏ผๅณๅไธไธชMapๅฏน่ฑก็ไปปไฝไธคไธชKey้่ฟequalsๆนๆณๆฏ่พไธญ่ฟๅfalse
                - Keyๅ Valueไน้ดๅญๅจๅๅไธๅฏนไธๅณ็ณป๏ผๅณ้่ฟๆๅฎ็Keyๆป่ฝๆพๅฐๅฏไธ็๏ผ็กฎๅฎ็Valueใ



                #### HashMap
                HashMapๆฏMapๆฅๅฃ็ๅธๅๅฎ็ฐ
                ```java
                Map<String, Object> map = new HashMap<>();
                ```
                ๅธธ็จๆนๆณ๏ผ
                ```java
                //1.ๆทปๅ?ๅ็ด?
                map.put("AA", new Person("AA", 12));//่ขซ่ฆ็
                map.put("AA", new Person("AAA", 12));
                map.put("CC", new Person("CCC", 12));
                map.put("MM", new Person("MMM", 12));
                map.put("DD", new Person("DDD", 12));
                //2.ๅๅบๅ็ด?๏ผ้ๅ๏ผ
                //2.1ๅพๅฐ้ฎ็้ๅ๏ผๅๅฉ็จ้ฎๅพๅฐๅผ
                Set keySet = map.keySet();
                for (Object key : keySet) {
                    System.out.println(key + ": " + map.get(key));
                }
                //2.2็ดๆฅๅพๅฐvalue็้ๅ
                Collection values = map.values();
                System.out.println(values.getClass());
                for (Object val : values) {
                    System.out.println(val);
                }
                //2.3ๅพๅฐ้ฎๅผๅฏน็้ๅ
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object val = entry.getValue();
                    System.out.println(key + ": " + val);
                }
                //3.็งป้คๅ็ด?
                map.remove("AA");
                //4.ๅทฅๅทๆนๆณ
                System.out.println(map.size());//3
                System.out.println(map);
                //contains(); isEmpty()
                System.out.println(map.containsKey("CC"));//true
                System.out.println(map.isEmpty());//false
                ```
                HashMapๅHashSet๏ผ[HashSet](#hashset) ๆฏ็ฑHashMapๅฎไน็
                #### Hashtable
                HashMapๆฏMapๆฅๅฃ็ๅค่ๅธๅๅฎ็ฐ๏ผไธๅปบ่ฎฎไฝฟ็จ
                Hashtableไธๅ่ฎธไฝฟ็จnull ไฝไธบkeyๅ value๏ผ่ HashMapๅฏไปฅ
                #### LinkedHashMap
                LinkedHashMap ๆฏ HashMap ็ๅญ็ฑป
                LinkedHashMapๅฏไปฅ็ปดๆค Map ็่ฟญไปฃ้กบๅบ:่ฟญไปฃ้กบๅบไธKey-Valueๅฏน็ๆๅฅ้กบๅบไธ่ด
                [LinkedHashSet](#linkedhashset) ๆฏ็ฑ LinkedHashMap ๅฎไน็
                #### TreeMap
                TreeMapๅญๅจKey-Value ๅฏนๆถ๏ผ้่ฆๆ?นๆฎKeyๅฏนkey-value ๅฏน่ฟ่กๆๅบใTreeMapๅฏไปฅไฟ่ฏๆๆ
                ็Key-Valueๅฏนๅคไบๆๅบ็ถๆใ
                ๆนๆณๅ่ [TreeSet](#treeset)
                ```java
                Comparator comparator = new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2){
                        Person p1 = (Person) o1;
                        Person p2 = (Person) o2;
                        return p1.getAge() - p2.getAge();//ๅขๅบ
                    }
                };
                //ๆณจๆ่ฆไผ?ๅฅcomparatorๅๆฐ๏ผๅช่ฝๅฏนkey่ฟ่กๆๅบ
                TreeMap tm = new TreeMap(comparator);
                tm.put(new Person("AA", 12), "AAA");
                tm.put(new Person("BB", 32), "AAA");
                tm.put(new Person("CC", 25), "AAA");
                tm.put(new Person("DD", 22), "AAA");
                //้ๅ
                keySet = tm.keySet();
                for (Object key : keySet) {
                    Object val = tm.get(key);
                    System.out.println(key + "๏ผ" + val);
                }
                /*่พๅบ
                Person [name='AA', age=12]๏ผAAA
                Person [name='DD', age=22]๏ผAAA
                Person [name='CC', age=25]๏ผAAA
                Person [name='BB', age=32]๏ผAAA
                */
                ```
                #### Properties
                Properties็ฑปๆฏHashtable็ๅญ็ฑป๏ผ่ฏฅๅฏน่ฑก็จไบๅค็ๅฑๆงๆไปถ
                ็ฑไบๅฑๆงๆไปถ้็keyใvalue้ฝๆฏๅญ็ฌฆไธฒ็ฑปๅ๏ผๆไปฅproperties้็ Keyๅ Value้ฝๆฏๅญ็ฌฆไธฒ็ฑปๅ็

                propertiesๆไปถๅจJavaไธญๅฏนไธไธช็ๆฏไธไธช Properties็ฑป็ๅฏน่ฑก
                ```properties
                url=jdbc:mysql:///test
                driver=com.mysql.jdbc.Driver
                user=root
                password=964538
                ```
                ๆนๆณ๏ผ
                ```java
                //1ใๅๅปบไธไธชProperties็ฑป็ๅฏน่ฑก
                Properties properties = new Properties();
                //2๏ผไฝฟ็จ IO ๆตๅ?่ฝฝๅฏนๅบ็propertiesๆไปถ๏ผๆณจๆๆๅผๅธธ
                properties.load(new FileInputStream("jdbproperties"));
                //3๏ผๅพๅฐๅฏนๅบ็ๅฑๆงๅผ
                String url = properties.getProperty("url");
                System.out.println(url);
                //่พๅบ๏ผjdbc:mysql:///test
                ```


                ### Collections ๅทฅๅท็ฑป

                CollectionsๆฏไธไธชๆไฝSetใListๅ Map็ญ้ๅ็ๅทฅๅท็ฑป

                #### ๆๅบๆนๆณ
                ```java
                reverse(List)
                //ๅ่ฝฌListไธญๅ็ด?็้กบๅบ
                shuffle(List)
                //ๅฏนList้ๅๅ็ด?่ฟ่ก้ๆบๆๅบ
                sort(List)
                //ๆ?นๆฎๅ็ด?็่ช็ถ้กบๅบๅฏนๆๅฎList้ๅๅ็งฆๆๅๅบๆๅบ
                sort(List , Comparator):
                //ๆ?นๆฎๆๅฎ็Comparatorไบง็็้กบๅบๅฏนList้ๅๅ็งฆ่ฟ่กๆๅบ
                swap(List , int , int)
                //ๅฐๆๅฎlist้ๅไธญ็iๅคๅ็ด?ๅjๅคๅ็งฆ่ฟ่กไบคๆข
                ```
                ๅฎไพ๏ผ

                ๆ?นๆฎๆๅฎ็Comparatorไบง็็้กบๅบๅฏนList้ๅๅ็งฆ่ฟ่กๆๅบ
                ```java
                Collections.sort(list, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        Person p1 = (Person) o1;
                        Person p2 = (Person) o2;
                        return p1.getAge() - p2.getAge();
                    }
                });
                ```
                #### ๆฅๆพ&ๆฟๆขๆนๆณ

                ```java
                Object max(Collection)
                //ๆ?นๆฎๅ็ด?็่ช็ถ้กบๅบ,่ฟๅ็ปๅฎ้ๅไธญ็ๆๅคงๅ็ด?
                Object max(Collection , Comparator)
                //ๆ?นๆฎComparatorๆๅฎ็้กบๅบ,่ฟๅ็ปๅฎ้ๅไธญ็ๆๅคงๅ็ด?
                Object min(Collection)
                Object min(Collection , Comparator)
                int frequency(Collection , Object)
                //่ฟๅๆ็้ๅ็ฒๆ็ๅ็ด?็ๅบ็ฐๆฌกๆฐ
                boolean replaceAll(List list , Object oldVal , Object newVal)
                //ไฝฟ็จๆฐๅผๆฟๆขListๅฏน่ฑก็ๆๆๆงๅผ
                ```
                ๅฎไพ๏ผ

                ๆ?นๆฎComparatorๆๅฎ็้กบๅบ,่ฟๅ็ปๅฎ้ๅไธญ็ๆๅคงๅ็ด?
                ```java
                System.out.println(Collections.max(list,new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        Person p1 = (Person) o1;
                        Person p2 = (Person) o2;
                        return p1.getAge() - p2.getAge();
                    }
                }));
                ```
                #### ๅๆญฅๆงๅถๆนๆณ

                ไฝฟ็จ synchronizedList(),ๅฐๅๆฐ้็้ๅๅๆ็บฟ็จๅฎๅจ็
                ```java
                //่ทๅ็บฟ็จๅฎๅจ็List ๅฏน่ฑก๏ผไฝฟ็จ synchronizedList()
                List list2 = Collections.synchronizedList(new ArrayList<>());
                ```
                ### Enumeration
                Enumeration ๆฅๅฃๆฏlterator่ฟญไปฃๅจ็โๅค่็ๆฌโ

                ๅฎไพ๏ผ
                ```java
                //ๅฏนEnumerationๅฏน่ฑก่ฟ่ก้ๅ hasMoreElements() nextElement()
                Enumeration names = Collections.enumerati(list);
                while (names.hasMoreElements()){
                    Object obj = names.nextElement();
                    System.out.println(obj);
                }
                ```
            """.trimIndent(),
            category = LocalCategoriesDataProvider.getCategoryById(2L),
            tag = listOf(1L, 2L, 3L).map { LocalTagsDataProvider.getTagById(it) },
            isStarred = false,
            createdAt = "30 mins ago"
        ),
        Note(
            id = 4L,
            author = LocalAccountsDataProvider.getContactAccountById(3L),
            subject = "Android็บฟๆงๅธๅฑ๏ผLinearLayout๏ผ",
            body = """
                # ็บฟๆงๅธๅฑ(LinearLayout)

                ## ็บฟๆงๅธๅฑ็ๆๅๆนๅผ

                ็บฟๆงๅธๅฑๅ้จ็ๅ่งๅพๆไธค็งๆๅๆนๅผ:

                - `orientation`ๅฑๆงๅผไธบ`horizontal`ๆถ๏ผๅ้จ่งๅพๅจๆฐดๅนณๆนๅไปๅทฆๅพๅณๆๅใ
                - `orientation`ๅฑๆงๅผไธบ`vertical`ๆถ๏ผๅ้จ่งๅพๅจๅ็ดๆนๅไปไธๅพไธๆๅใ
                - ๅฆๆไธๆๅฎ`orientation`ๅฑๆง๏ผๅ`LinearLayout`้ป่ฎคๆฐดๅนณๆนๅๆๅใ

                ## ็บฟๆงๅธๅฑ็ๆ้

                ็บฟๆงๅธๅฑ็ๆ้ๆฆๅฟต๏ผๆ็ๆฏ็บฟๆงๅธๅฑ็ไธ็บง่งๅพๅ่ชๆฅๆๅคๅคงๆฏไพ็ๅฎฝ้ซใ

                ๆ้ๅฑๆงๅๅซ`layout_weight`๏ผไฝ่ฏฅๅฑๆงไธๅจ`LinearLayout`่็น่ฎพ็ฝฎ๏ผ่ๅจ็บฟๆงๅธๅฑ็็ดๆฅไธ็บง่งๅพ่ฎพ็ฝฎ๏ผ่กจ็คบ่ฏฅไธ็บง่งๅพๅ?ๆฎ็ๅฎฝ้ซๆฏไพใ
                - `layout_width`ๅกซ`0dp`ๆถ๏ผ`layout_weight`่กจ็คบๆฐดๅนณๆนๅ็ๅฎฝๅบฆๆฏไพใ
                - `layout_height`ๅกซ`0dp`ๆถ๏ผ`layout_weight`่กจ็คบๅ็ดๆนๅ็้ซๅบฆๆฏไพใ
            """.trimIndent(),
            category = LocalCategoriesDataProvider.getCategoryById(1L),
            tag = listOf(0L).map { LocalTagsDataProvider.getTagById(it) },
            isStarred = false,
            createdAt = "2 hours ago"
        ),
        Note(
            id = 5L,
            author = LocalAccountsDataProvider.getContactAccountById(6L),
            subject = "Kotlinๅฝๆฐ",
            body = """
                ## Kotlinๅฝๆฐ

                ### ๅฝๆฐๅคด

                ```Kotlin
                     private       fun        doSomething(age:Int, flag:Boolean) : String
                // ๅฏ่ง่กไฟฎ้ฅฐ็ฌฆ  ๅฝๆฐๅฃฐๆๅณ้ฎๅญ   ๅฝๆฐๅ            ๅฝๆฐๅๆฐ          ่ฟๅ็ฑปๅ
                ```

                ### ๅฝๆฐๅๆฐ 

                ๏ผ1๏ผ้ป่ฎคๅผๅ

                ๅฆๆไธๆ็ฎไผ?ๅฅๅผๅ๏ผๅฏไปฅ้ขๅ็ปๅๆฐๆๅฎ้ป่ฎคๅผ

                ```Kotlin
                fun fix(name: String, age: Int = 6) {
                    println(name + age)
                }
                // ไธปๅฝๆฐ
                fun main() {
                    fix("Yorick")
                }
                ```
                ๏ผ2๏ผๅทๅๅฝๆฐๅๆฐ

                ๅฆๆไฝฟ็จๅฝๅๅผๅ๏ผๅฐฑๅฏไปฅไธ็จ็ฎกๅผๅ็้กบๅบ

                ```Kotlin
                fun main() {
                    fix(age = 9, name = "Jerry")
                }
                ```
                ### Unitๅฝๆฐ

                ไธๆฏๆๆๅฝๆฐ้ฝๆ่ฟๅๅผ๏ผKotlinไธญๆฒกๆ่ฟๅๅผ็ๅฝๆฐๅซUnitๅฝๆฐ๏ผไนๅฐฑๆฏ่ฏดไปไปฌ็่ฟๅ็ฑปๅๆฏUnitใๅจKotlinไนๅ๏ผๅฝๆฐไธ่ฟๅไปปไฝไธ่ฅฟ็จvoidๆ่ฟฐ๏ผๆๆๆฏ"ๆฒกๆ่ฟๅ็ฑปๅ๏ผไธไผๅธฆๆฅไปไน๏ผๅฟฝ็ฅๅฎ"๏ผไนๅฐฑๆฏ่ฏดๅฆๆๅฝๆฐไธ่ฟๅไปปไฝไธ่ฅฟ๏ผๅฐฑๅฟฝ็ฅ็ฑปๅใไฝๆฏ๏ผvoid่ฟ็ง่งฃๅณๆนๆกๆ?ๆณ่งฃ้็ฐไปฃ่ฏญ่จ็ไธไธช้่ฆ็นๅพ๏ผๆณๅใ

                ```Kotlin
                println(fix("Yorick"))
                // ่พๅบ
                // Yorick6
                // kotlin.Unit
                ```

                ### Nothing็ฑปๅ

                TODOๅฝๆฐ็ไปปๅกๅฐฑๆฏๆๅบๅผๅธธ๏ผๅฐฑๆฏๆฐธ่ฟๅซๆๆๅฎ่ฟ่กๆๅ๏ผ่ฟๅNothing็ฑปๅ

                ```Kotlin
                TODO("nothing")
                // ไธ้ข่ฏญๅฅไธไผ่ขซๆง่ก
                println("after nothing")
                ```
                TODOๅฝๆฐๆฌ่บซๅฐฑๆฏ่ฟๅไธไธชๅผๅธธ
                ```kotlin
                public inline fun TODO(reason: String): Nothing = throw NotImplementedError("An operation is not implemented: ^reason")
                ```

                ### ๅๅผๅทไธญ็ๅฝๆฐๅ

                ๏ผ1๏ผๅฏไปฅ็ปๅฝๆฐ่ตทๅฅๆช็ๅๅญ๏ผๅฐๅฟ่ขซๆๆญปqaq๏ผ
                ```Kotlin
                // ๅฎไน
                fun `****Yorick is the best****`(name: String){
                    println(name+"666")
                }
                // ่ฐ็จ
                `****Yorick is the best****`("Yorick")
                // ่พๅบ
                // Yorick666
                ```
                ๏ผ2๏ผ็ฑไบJavaๅKotlinๅฏไปฅ็ธไบ่ฐ็จ๏ผไฝๆฏไธค่ๅณ้ฎๅญไธๅ๏ผไผๆๅจ็ฅ๏ผๅณ้ฎๅญไธ่ฝไฝไธบๅ้ๅๆ่ๆ?่ฏ็ฌฆ๏ผๆไปฅๆๆถๅ่ฆๅ?ๅๅผๅทใ

                - ๆฐๅปบMyJava็ฑปๅฎไนis้ๆๆนๆณ
                ```Kotlin
                public class MyJava {
                    public static void is(){
                        System.out.println("IS");
                    }
                }
                ```
                - ๅจKotlinไธญ่ฐ็จisๆนๆณ
                ```Kotlin
                fun main() {
                    MyJava.`is`();
                }
                // ่พๅบ
                IS
                ```
            """.replace("^", "$").trimIndent(),
            category = LocalCategoriesDataProvider.getCategoryById(0L),
            isStarred = true,
            createdAt = "2 days ago"
        ),
        Note(
            id = 6L,
            author = LocalAccountsDataProvider.getContactAccountById(4L),
            subject = "Kotlinๆ?ๅๅบๅฝๆฐ",
            body = """
                ## ๆ?ๅๅบๅฝๆฐ

                ### apply
                
                applyๅฝๆฐๅฏ็ไฝไธไธช้็ฝฎๅฝๆฐ๏ผไฝ?ๅฏไปฅไผ?ๅฅไธไธชๆฅๆถ่๏ผ็ถๅ่ฐ็จไธ็ณปๅ้็ฝฎไปฅไพฟๅฎไฝฟ็จ๏ผๅฆๆๆไพlambda็ปapplyๅฝๆฐๆง่ก๏ผๅฎไผ่ฟๅ้็ฝฎๅฅฝ็ๆฅๆถ่ใ
                
                ```kotlin
                fun main() {
                    // ้็ฝฎไธไธชFileๅฎไพ
                    val file1 = File("E://demo.txt")
                    file1.setReadable(true)
                    file1.setWritable(true)
                    file1.setExecutable(false)
                    // ไฝฟ็จapply
                    val file2 = File("E://demo.txt").apply {
                        // ่ฟ้ๅฏไปฅ็็ฅthis
                        // ๆๆๆไฝ้ป่ฎคๆฅๆถ่ไธบfile2
                        // ่ฟไนๅซ้ๅผ่ฐ็จ
                        setReadable(true)
                        setWritable(true)
                        setExecutable(false)
                    }
                }
                ```
                ### let
                ๅไธ้ขapplyๅทฎไธๅค๏ผไฝๆฏไผ่ฟๅlambdaๅฝๆฐ็ๆๅไธ่ก็็ปๆ๏ผๅนถ่ตๅผ็ปๆฅๆถ่๏ผไฝๆฏไธๆฏๆ้ๅผ่ฐ็จใ
                ```kotlin
                fun main() {
                    // ๆฑ้ๅ็ฌฌไธไธชๅ็ด?็ๅนณๆน
                    val res = listOf(8, 6, 9).first().let {
                        it * it
                    }
                    println(res)
                    // ไธ็จlet
                    val firstElement = listOf(8, 6, 9).first()
                    val res2 = firstElement * firstElement
                    println(res2)
                }
                ```
                ้ๅๅฎๅจๆไฝ็ฌฆไฝฟ็จใ
                ```kotlin
                fun main() {
                    println(formatGreeting(null)) // What's your name?
                    println(formatGreeting("Yorick")) // Hello! Yorick.
                    println(formatGreeting1(null)) // What's your name?
                    println(formatGreeting1("Yorick")) // Hello! Yorick.
                }
                // ไฝฟ็จlet่ฟ่ก้พๅผ่ฐ็จ
                fun formatGreeting(guestName: String?): String {
                    return guestName?.let {
                        "Hello! ^it."
                    } ?: "What's your name?"
                }
                // ไผ?็ปๆนๅผ
                fun formatGreeting1(guestName: String?): String {
                    return if (guestName != null) {
                        "Hello! ^guestName."
                    } else {
                        "What's your name?"
                    }
                }
                ```
                ### run
                
                ็ปๅไบletๅapply๏ผๅฏไปฅๅletไธๆ?ท่ฟๅlambdaๆๅไธ่ก็ปๆ๏ผๅๆถๅฏไปฅๅapplyไธๆ?ท้ๅผ่ฐ็จใ
                
                ```kotlin
                // ๅคๆญๆไปถๆฏๅฆๅๅซๆๅญ็ฌฆ
                fun main() {
                    val file = File("E://demo.txt")
                    val res = file.run {
                        readText().contains("demo")
                    }
                    println(res) // true
                }
                ```
                
                ๅฆๅค๏ผrunไน่ฝ็จๆฅๆง่กๅฝๆฐๅผ็จ
                
                ```kotlin
                fun main() {
                    //::่กจ็คบๆไธไธชๆนๆณๅฝๅไธไธชๅๆฐ๏ผไผ?้ๅฐๅฆไธไธชๆนๆณไธญ่ฟ่กไฝฟ็จ๏ผ้ไฟ็ๆฅ่ฎฒๅฐฑๆฏๅผ็จไธไธชๆนๆณใ
                    "The People's Republic of China"
                        .run(::isLong)
                        .run(::showMessage)
                        .run(::println)
                }
                
                fun isLong(str: String) = str.length >= 10
                
                fun showMessage(isLong: Boolean): String {
                    return if (isLong) {
                        "String is too long!"
                    } else {
                        "OK!"
                    }
                }
                // ่พๅบ
                // String is too long!
                ```
                
                ### with
                
                withๅฝๆฐๆฏrun็ๅไฝ๏ผไปไปฌ็ๅ่ฝ่กไธบๆฏไธๆ?ท็๏ผไฝwith็่ฐ็จๆนๅผไธๅ๏ผ่ฐ็จwithๆถ้่ฆๅผๅไฝไธบๅถ็ฌฌไธไธชๅๆฐไผ?ๅฅใ
                
                
                ```kt
                fun main() {
                    // ไฝฟ็จrun
                    val res1 = "The People's Republic of China".run {
                        length > 10
                    }
                    println(res1)
                    // ไฝฟ็จwith
                    val res2 = with("The People's Republic of China") {
                        length > 10
                    }
                    println(res2)
                }
                // ่พๅบ
                // true
                // true
                ```
                
                ### also
                
                ๅlet็ธไผผ๏ผๆๆฅๆถ่ไผ?็ปlambda๏ผไฝๆฏ่ฟๅ็ๆฏๅๅงๅฏน่ฑก๏ผๅธธ็จไบ้พๅผ่ฐ็จใ
                
                ```kt
                fun main() {
                    val fileContents: List<String>
                    File("E://demo.txt")
                        .also {
                            println(it.name)
                        }.also {
                            fileContents = it.readLines()
                        }
                    println(fileContents)
                }
                // ่พๅบ็คบไพ
                // demo.txt
                // [demo, demo, hhhh, edited by Yorick, 2022ๅนด9ๆ8ๆฅ11็น32ๅ]
                ```
                
                ### takeIf
                
                ็ฑปไผผif๏ผๅคๆญๆฅๆถ่ๆฏๅฆๆปก่ถณlambda็่กจ่พพๅผ๏ผๆปก่ถณ่ฟๅๆฅๆถ่๏ผไธๆปก่ถณๅ่ฟๅnullใ
                ```kt
                fun main() {
                    val res = File("E://demo.txt")
                        .takeIf { it.exists() && it.canRead() }
                        ?.readText()
                    println(res)
                }
                // ่พๅบๆไปถๅๅฎน
                ```
                
                ### takeUnless
                
                takeIf็ๅฆๅฎ๏ผfalseๆ่ฟๅๅฏน่ฑก๏ผtrue่ฟๅnull
                
                ```kotlin
                fun main() {
                    val res = File("E://demo.txt")
                        .takeUnless { it.isHidden }
                        ?.readText()
                    println(res)
                }
                ```
            """.replace("^", "$").trimIndent(),
            category = LocalCategoriesDataProvider.getCategoryById(0L),
            isStarred = true,
            createdAt = "3 days ago"
        ),
    )
}